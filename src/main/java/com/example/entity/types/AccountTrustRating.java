package com.example.entity.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum AccountTrustRating {

    // select * from account a where a.account_trust_rating in (1,2)
    GREEN(1),
    ORANGE(2),
    RED(3)

    ;

    private final Integer id;

    public static AccountTrustRating findById(Integer id) {
        if (id == null) {
            return null;
        }

        return Arrays.stream(AccountTrustRating.values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                String.format("No such Account Trust Rating with id [%s]", id)
                        )
                );
    }
}
