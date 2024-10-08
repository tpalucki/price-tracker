package io.github.tpalucki.pricetracker;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;

@Component
public class DescriptionExtractor {

    public Description parseDescription(String description) {
        String[] descriptionParts = description.split(", ");
        Integer year = Integer.parseInt(descriptionParts[0].split(": ")[1]);
        Integer elements = Integer.parseInt(descriptionParts[1].split(": ")[1]);
        BigDecimal pricePerElement = new BigDecimal(descriptionParts[2].split(": ")[1].replace("zł", "").replace(",", "."));
        Currency currency = Currency.getInstance("PLN");

        return new Description(year, elements, pricePerElement, currency);
    }

    record Description(Integer year, Integer elements, BigDecimal pricePerElement, Currency currency) {
    }
}
