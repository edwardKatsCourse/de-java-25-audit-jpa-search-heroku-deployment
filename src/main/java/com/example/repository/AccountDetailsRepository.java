package com.example.repository;

import com.example.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

    AccountDetails findByAccount_Id(Long accountId);
}
