package com.example.entity.types;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AccountTrustRatingConverter implements AttributeConverter<AccountTrustRating, Integer> {
    @Override
    public Integer convertToDatabaseColumn(AccountTrustRating attribute) {
        return attribute.getId();
    }

    @Override
    public AccountTrustRating convertToEntityAttribute(Integer dbData) {
        return AccountTrustRating.findById(dbData);
    }
}
