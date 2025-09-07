package kg.yiman.backend.auth.service;

import kg.yiman.backend.auth.model.RefreshToken;
import kg.yiman.backend.auth.repository.RefreshTokenRepository;
import kg.yiman.backend.auth.util.JwtUtil;
import kg.yiman.backend.user.model.User;
import kg.yiman.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

  private final RefreshTokenRepository refreshTokenRepository;
  private final UserRepository userRepository;
  private final JwtUtil jwtUtil;

  public RefreshTokenService(RefreshTokenRepository repo, UserRepository userRepository, JwtUtil jwtUtil) {
    this.refreshTokenRepository = repo;
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
  }

  public RefreshToken createRefreshToken(UUID userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));

    RefreshToken refreshToken = new RefreshToken();
    refreshToken.setUser(user);
    refreshToken.setToken(UUID.randomUUID().toString());
    refreshToken.setExpiry(Instant.now().plus(7, ChronoUnit.DAYS));

    return refreshTokenRepository.save(refreshToken);
  }

  public Optional<RefreshToken> findByToken(String token) {
    return refreshTokenRepository.findByToken(token);
  }

  public void revokeRefreshToken(RefreshToken token) {
    token.setRevoked(true);
    refreshTokenRepository.save(token);
  }

  public void revokeAllForUser(UUID userId) {
    refreshTokenRepository.deleteAllByUserId(userId);
  }

  public boolean isTokenValid(RefreshToken token) {
    return token != null && !token.isRevoked() && token.getExpiry().isAfter(Instant.now());
  }
}
