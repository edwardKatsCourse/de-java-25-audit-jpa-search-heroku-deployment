package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_password")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountPassword extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true, nullable = false)
    private Account account;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "salt")
    private String salt;
}


// GDPR: Global Data Protection Regulation