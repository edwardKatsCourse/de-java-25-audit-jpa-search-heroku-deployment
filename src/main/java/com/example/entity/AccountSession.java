package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_session")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "session_id", unique = true, nullable = false)
    private String sessionId;

    @JoinColumn(name = "account_id", nullable = false)
    @OneToOne
    private Account account;

}
