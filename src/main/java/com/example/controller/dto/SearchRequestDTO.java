package com.example.controller.dto;

import com.example.entity.types.AccountTrustRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchRequestDTO {

    private String name;
    private String country;
    private String city;
    private AccountTrustRating trustRating;
}
