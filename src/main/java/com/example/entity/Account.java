package com.example.entity;

import com.example.entity.types.AccountTrustRating;
import com.example.entity.types.AccountTrustRatingConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "name")
    private String name;

    @Convert(converter = AccountTrustRatingConverter.class)
    @Column(name = "account_trust_rating")
    private AccountTrustRating accountTrustRating;
}
