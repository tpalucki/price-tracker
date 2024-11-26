package io.github.tpalucki.pricetracker.product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class TitleExtractor {

    private static final Logger log = LoggerFactory.getLogger(TitleExtractor.class);

    public Optional<Title> parseTitle(String titleText) {
        try {
            String[] titleParts = titleText.split("-", 2);
            String title = titleParts[1].trim();

            String companyCategoryAndSetId = titleParts[0].trim();
            String[] companyCategoryAndSetIdParts = companyCategoryAndSetId.split(" ");

            String producer = companyCategoryAndSetIdParts[0];
            String setId = companyCategoryAndSetIdParts[companyCategoryAndSetIdParts.length - 1];
            String category = String.join(" ", companyCategoryAndSetIdParts).replace(producer, "")
                    .replace(setId, "")
                    .trim();

            return of(new Title(producer, category, setId, title));
        } catch (RuntimeException exception) {
            log.warn("Failed to parse title: {}", titleText);
            return empty();
        }
    }

    record Title(String company, String category, String setId, String title) {
    }
}
