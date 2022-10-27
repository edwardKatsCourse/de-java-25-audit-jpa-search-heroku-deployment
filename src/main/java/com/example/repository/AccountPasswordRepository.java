package com.example.repository;

import com.example.entity.Account;
import com.example.entity.AccountPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountPasswordRepository extends JpaRepository<AccountPassword, Long> {

    AccountPassword findByAccount(Account account);
}
