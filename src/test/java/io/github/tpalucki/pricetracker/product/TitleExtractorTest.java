package io.github.tpalucki.pricetracker.product;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TitleExtractorTest {

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("LEGO Ninja 4819 - Bull's Attack Wagon",
                        new TitleExtractor.Title("LEGO", "Ninja", "4819", "Bull's Attack Wagon")),
                Arguments.of("LEGO City 60226 - Mars Research Shuttle",
                        new TitleExtractor.Title("LEGO", "City", "60226", "Mars Research Shuttle")),
                Arguments.of("LEGO Star Wars 75256 - Kylo Ren's Shuttle",
                        new TitleExtractor.Title("LEGO", "Star Wars", "75256", "Kylo Ren's Shuttle")),
                Arguments.of("LEGO Marvel Super Heroes 76294 - X-Men: Instytut Xaviera",
                        new TitleExtractor.Title("LEGO", "Marvel Super Heroes", "76294", "X-Men: Instytut Xaviera"))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void shouldParseTitleDetails(String titleText, TitleExtractor.Title expectedTitle) {
        // given
        TitleExtractor titleExtractor = new TitleExtractor();

        // when
        TitleExtractor.Title title = titleExtractor.parseTitle(titleText).get();

        // then
        assertEquals(expectedTitle.company(), title.company());
        assertEquals(expectedTitle.category(), title.category());
        assertEquals(expectedTitle.setId(), title.setId());
        assertEquals(expectedTitle.title(), title.title());
    }
}