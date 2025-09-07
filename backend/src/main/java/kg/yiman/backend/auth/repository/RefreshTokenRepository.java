package kg.yiman.backend.auth.repository;

import kg.yiman.backend.auth.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
  Optional<RefreshToken> findByToken(String token);
  List<RefreshToken> findAllByUserIdAndRevokedFalse(UUID userId);
  void deleteAllByUserId(UUID userId);
}

