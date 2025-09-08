package kg.yiman.backend.auth.job;

import kg.yiman.backend.auth.service.RefreshTokenService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenJobs {

    private final RefreshTokenService refreshTokenService;

    public RefreshTokenJobs(RefreshTokenService refreshTokenService) {
        this.refreshTokenService = refreshTokenService;
    }

    @Scheduled(cron = "0 * * * * ?")
    public void cleanExpiredTokens() {
        refreshTokenService.cleanExpiredTokens();
    }
}
