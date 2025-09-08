package kg.yiman.backend.auth.repository;

import kg.yiman.backend.auth.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
  Optional<RefreshToken> findByToken(String token);
  void deleteAllByUserId(UUID userId);
  void deleteByExpiryBeforeOrRevokedTrue(Instant now);
}

