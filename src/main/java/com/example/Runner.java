package com.example;

import com.example.entity.Account;
import com.example.entity.AccountDetails;
import com.example.entity.types.AccountTrustRating;
import com.example.repository.AccountDetailsRepository;
import com.example.repository.AccountRepository;
import com.example.service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Transactional
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    private final PasswordService passwordService;
    private final AccountRepository accountRepository;
    private final AccountDetailsRepository accountDetailsRepository;

    private final List<AccountDetails> accounts = List.of(
            AccountDetails.builder()
                    .country("DE")
                    .city("Berlin")
                    .account(Account.builder()
                            .name("John Doe")
                            .username("jdoe")
                            .accountTrustRating(AccountTrustRating.RED)
                            .build())
                    .isActive(true)
                    .build(),

            AccountDetails.builder()
                    .country("DE")
                    .city("Hamburg")
                    .account(Account.builder()
                            .accountTrustRating(AccountTrustRating.RED)
                            .name("Marry Poppins")
                            .username("mpoppins")
                            .build())
                    .isActive(false)
                    .build(),

            AccountDetails.builder()
                    .country("FR")
                    .city("Paris")
                    .account(Account.builder()
                            .accountTrustRating(AccountTrustRating.ORANGE)
                            .name("Peter Dale")
                            .username("pdale")
                            .build())
                    .isActive(true)
                    .build(),

            AccountDetails.builder()
                    .country("GB")
                    .city("London")
                    .account(Account.builder()
                            .accountTrustRating(AccountTrustRating.GREEN)
                            .name("Jane Stone")
                            .username("jstone")
                            .build())
                    .isActive(false)
                    .build()
    );

    @Override
    public void run(String... args) throws Exception {

        accounts.forEach(accountDetails -> {
            accountRepository.save(accountDetails.getAccount());
            accountDetailsRepository.save(accountDetails);
            passwordService.generateAndSavePassword(accountDetails.getAccount(), "123456");
        });



    }

}

class A {
    public static void main(String[] args) {
        System.out.println(System.getenv("JAVA_25"));
    }
}