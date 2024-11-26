package io.github.tpalucki.pricetracker.product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class DescriptionExtractor {

    private static final Logger log = LoggerFactory.getLogger(DescriptionExtractor.class);

    public Optional<Description> parseDescription(String description) {
        try {
            String[] descriptionParts = description.split(", ");
            Integer year = Integer.parseInt(descriptionParts[0].split(": ")[1]);
            Integer elements = Integer.parseInt(descriptionParts[1].split(": ")[1]);
            BigDecimal pricePerElement = new BigDecimal(descriptionParts[2].split(": ")[1].replace("zł", "").replace(",", "."));
            Currency currency = Currency.getInstance("PLN");

            return of(new Description(year, elements, pricePerElement, currency));
        } catch (RuntimeException exception) {
            log.warn("Failed to parse description: {}", description);
            return empty();
        }
    }

    record Description(Integer year, Integer elements, BigDecimal pricePerElement, Currency currency) {
    }
}
