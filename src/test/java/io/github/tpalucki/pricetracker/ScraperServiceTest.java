package io.github.tpalucki.pricetracker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

class ScraperServiceTest {

    private final DescriptionExtractor descriptionExtractor = new DescriptionExtractor();

    @Test
    void shouldScrape() throws IOException {
        var baseUrl = "https://promoklocki.pl";

        Document parse = Jsoup.parse(Path.of("src/test/resources/page.html").toFile(), "UTF-8");

        parse.select(".content > .product")
                .forEach(product -> {
                    var title = product.select("div > a").attr("title");
                    var link = baseUrl + product.select("div > a").attr("href");
                    var smallImg = baseUrl + product.select("div > a > img").attr("src");
                    var mediumImg = smallImg.replace(".s", ".m");
                    var bigImg = smallImg.replace(".s", ".b");
                    var oryginalImg = smallImg.replace(".s", "");
                    var descriptionText = product.select("div:nth-child(2) > p").text();
                    var description = descriptionExtractor.parseDescription(descriptionText);
                    var year = description.year();
                    var elements = description.elements();
                    var pricePerElement = description.pricePerElement();
                    var currency = description.currency();
                    var currentMinimalPrice = product.select("div:nth-child(3) > div > a > strong").text();
                    System.out.println(title +
                                       "\n - " + link +
                                       "\n - " + year +
                                       "\n - " + elements +
                                       "\n - " + pricePerElement + currency +
                                       "\n - " + currentMinimalPrice +
                                       "\n - " + smallImg +
                                       "\n - " + mediumImg +
                                       "\n - " + bigImg +
                                       "\n - " + oryginalImg
                    );
                });
    }
}