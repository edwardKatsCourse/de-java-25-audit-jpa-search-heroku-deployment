package com.example.configuration;

import com.example.entity.Account;
import com.example.entity.AccountSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ApplicationAuditConfiguration {



    @Bean
    public AuditorAware<Long> auditorAware() {
        // accountRepository.save()
        return () -> {
            var key = SecurityContextHolder.getContext().getAuthentication();
            if (key == null) {
                return Optional.empty();
            }

            AccountSession session = (AccountSession)key.getPrincipal();
            Account account = session.getAccount();
            return Optional.of(account.getId());
        };
    }

}
