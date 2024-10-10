package io.github.tpalucki.pricetracker.product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ScraperService {

    private final ProductRepository productRepository;

    public ScraperService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void scrape() {
        Document document = null;
        DescriptionExtractor descriptionExtractor = new DescriptionExtractor();
        try {
            // fetching the target website
            var baseUrl = "https://promoklocki.pl";
            var pageQueryParam = "p=";
            document = Jsoup.connect(baseUrl + "?" + pageQueryParam + "1")
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .header("Accept-Language", "*")
                    .get();

            document.select(".content > .product")
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
                        var currentMinimalPrice = toDecimal(product.select("div:nth-child(3) > div > a > strong").text());
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

                        productRepository.insert(new Product(
                                UUID.randomUUID(),
                                title,
                                link,
                                year,
                                elements,
                                pricePerElement,
                                currency,
                                currentMinimalPrice,
                                smallImg,
                                mediumImg,
                                bigImg,
                                oryginalImg,
                                descriptionText
                        ));
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BigDecimal toDecimal(String text) {
        return text.isEmpty() ? BigDecimal.ZERO : new BigDecimal(text.replace(",", "."));
    }
}
