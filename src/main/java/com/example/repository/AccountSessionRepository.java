package com.example.repository;

import com.example.entity.AccountSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountSessionRepository extends JpaRepository<AccountSession, Long> {

    AccountSession findBySessionId(String sessionId);
}
