package kg.yiman.backend.auth.controller;

import kg.yiman.backend.auth.dto.AuthRequest;
import kg.yiman.backend.auth.dto.RefreshRequest;
import kg.yiman.backend.auth.model.RefreshToken;
import kg.yiman.backend.auth.service.RefreshTokenService;
import kg.yiman.backend.auth.util.JwtUtil;
import kg.yiman.backend.user.model.Role;
import kg.yiman.backend.user.model.User;
import kg.yiman.backend.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authManager;
  private final JwtUtil jwtUtil;
  private final RefreshTokenService refreshTokenService;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil,
                        RefreshTokenService refreshTokenService, UserRepository userRepository,
                        PasswordEncoder passwordEncoder) {
    this.authManager = authManager;
    this.jwtUtil = jwtUtil;
    this.refreshTokenService = refreshTokenService;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthRequest req) {
    System.out.println("HELLO FROM LOGIN ROUTE");
    var auth = authManager.authenticate(
        new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
    );

    User user = userRepository.findByUsername(req.getUsername())
        .orElseThrow(() -> new RuntimeException("User not found"));

    String accessToken = jwtUtil.generateAccessToken(
        user.getUsername(),
        Map.of("roles", user.getRoles().stream().map(Role::getName).toList()).toString()
    );

    RefreshToken rt = refreshTokenService.createRefreshToken(user.getId());

    return ResponseEntity.ok(Map.of(
        "accessToken", accessToken,
        "refreshToken", rt.getToken()
    ));
  }

  @PostMapping("/refresh")
  public ResponseEntity<?> refresh(@RequestBody RefreshRequest request) {
    var maybe = refreshTokenService.findByToken(request.getRefreshToken());
    if (maybe.isEmpty()) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");

    RefreshToken token = maybe.get();
    if (!refreshTokenService.isTokenValid(token)) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token expired or revoked");
    }

    User user = token.getUser();
    String newAccess = jwtUtil.generateAccessToken(
        user.getUsername(),
        Map.of("roles", user.getRoles().stream().map(Role::getName).toList()).toString()
    );

    // rotate refresh token
    refreshTokenService.revokeRefreshToken(token);
    RefreshToken newRt = refreshTokenService.createRefreshToken(user.getId());

    return ResponseEntity.ok(Map.of(
        "accessToken", newAccess,
        "refreshToken", newRt.getToken()
    ));
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logout(@RequestBody RefreshRequest request) {
    refreshTokenService.findByToken(request.getRefreshToken())
        .ifPresent(refreshTokenService::revokeRefreshToken);
    return ResponseEntity.noContent().build();
  }
}
