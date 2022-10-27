package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.time.LocalDateTime;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity<U> {


    // @PrePersist
    @CreatedBy
    private U createdById;

    // @PrePersist
    @CreatedDate
    private Instant createdOn;

    // @PreUpdate
    @LastModifiedBy
    private U updatedBy;

    // @PreUpdate
    @LastModifiedDate
    private Instant updatedOn;
}


class A {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

        // 03:00 => 18:00

        // UTC => 00:00
        // timeZ => 00:00
        System.out.println(Instant.now());
    }
}