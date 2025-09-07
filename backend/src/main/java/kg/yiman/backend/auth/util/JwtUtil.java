package kg.yiman.backend.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

  private final SecretKey secretKey;
  private final long accessTokenValidity = 15 * 60 * 1000; // 15 minutes
  private final long refreshTokenValidity = 7 * 24 * 60 * 60 * 1000; // 7 days

  public JwtUtil(@Value("${jwt.secret}") String secret) {
    // ✅ Proper decoding for jjwt 0.12.x
    byte[] keyBytes = Base64.getDecoder().decode(secret.getBytes(StandardCharsets.UTF_8));
    this.secretKey = Keys.hmacShaKeyFor(keyBytes);
  }

  // 🔑 Generate Access Token
  public String generateAccessToken(String username, String role) {
    return Jwts.builder()
        .subject(username)
        .claim("role", role)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + accessTokenValidity))
        .signWith(secretKey)
        .compact();
  }

  // 🔑 Generate Refresh Token
  public String generateRefreshToken(String username, String role) {
    return Jwts.builder()
        .subject(username)
        .claim("role", role)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + refreshTokenValidity))
        .signWith(secretKey)
        .compact();
  }

  // ✅ Validate token
  public void validateToken(String token) {
    try {
      Jwts.parser()
          .verifyWith(secretKey)
          .build()
          .parseSignedClaims(token);

    } catch (SignatureException e) {
      throw new JwtException("Invalid JWT signature");
    } catch (JwtException e) {
      throw new JwtException("Invalid JWT token");
    }
  }

  // ✅ Extract claims
  private Claims extractAllClaims(String token) {
    return Jwts.parser()
        .verifyWith(secretKey)
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }

  public String extractUsername(String token) {
    return extractAllClaims(token).getSubject();
  }

  public String extractRole(String token) {
    return extractAllClaims(token).get("role", String.class);
  }

  public Date extractExpiration(String token) {
    return extractAllClaims(token).getExpiration();
  }

  public boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }
}
