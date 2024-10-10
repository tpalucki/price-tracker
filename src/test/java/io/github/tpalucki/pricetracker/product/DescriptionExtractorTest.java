package io.github.tpalucki.pricetracker.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescriptionExtractorTest {

    DescriptionExtractor descriptionExtractor = new DescriptionExtractor();

    @Test
    void shouldExtractYearFromDescription() {
        var descriptionString = "Rok: 2025, liczba elementów: 322, cena/el: 0,56zł";

        DescriptionExtractor.Description description = descriptionExtractor.parseDescription(descriptionString);

        assertEquals(2025, description.year());
        assertEquals(322, description.elements());
        assertEquals(new BigDecimal("0.56"), description.pricePerElement());
        assertEquals(Currency.getInstance("PLN"), description.currency());
    }
}