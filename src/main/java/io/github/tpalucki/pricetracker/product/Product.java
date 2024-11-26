package io.github.tpalucki.pricetracker.product;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

public record Product(
        UUID id,
        String title,
        String link,
//        Integer year,
//        Integer elements,
//        BigDecimal pricePerElement,
//        Currency currency,
//        BigDecimal currentMinimalPrice,
        String smallImg,
        String mediumImg,
        String bigImg,
        String oryginalImg
//        ,
//        String description
) {
}
