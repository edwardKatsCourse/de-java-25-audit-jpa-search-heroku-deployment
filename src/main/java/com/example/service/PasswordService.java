package com.example.service;

import com.example.entity.Account;
import com.example.entity.AccountPassword;
import com.example.repository.AccountPasswordRepository;
import com.example.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordService {

    private final AccountRepository accountRepository;
    private final AccountPasswordRepository accountPasswordRepository;

    public void generateAndSavePassword(Account account, String password) {
        String salt = BCrypt.gensalt();
        String encryptedPassword = BCrypt.hashpw(password, salt);

        AccountPassword accountPassword = AccountPassword.builder()
                .account(account)
                .salt(salt)
                .passwordHash(encryptedPassword)
                .build();

        accountPasswordRepository.save(accountPassword);
    }


    public Account getMatchedAccount(String username, String password) {
        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            return null;
        }

        AccountPassword accountPassword = accountPasswordRepository.findByAccount(account);

        var actualPasswordHash = BCrypt.hashpw(password, accountPassword.getSalt());

        // 123456 -> aaaaaa

        // 123457 -> abaaaa             aaaaaa
//        if (actualPasswordHash.equals(accountPassword.getPasswordHash())) {
//            return account;
//        }
//        return null;

        return actualPasswordHash.equals(accountPassword.getPasswordHash()) ? account : null;

        // google login
        // facebook login
    }
}
