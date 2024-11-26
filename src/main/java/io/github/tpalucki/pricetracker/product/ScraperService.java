package io.github.tpalucki.pricetracker.product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class ScraperService {

    private static final Logger log = LoggerFactory.getLogger(ScraperService.class);

    private final ProductRepository productRepository;
    private final DescriptionExtractor descriptionExtractor;
    private final TitleExtractor titleExtractor;

    public ScraperService(ProductRepository productRepository, DescriptionExtractor descriptionExtractor, TitleExtractor titleExtractor) {
        this.productRepository = productRepository;
        this.descriptionExtractor = descriptionExtractor;
        this.titleExtractor = titleExtractor;
    }

    public void scrape() {
        var baseUrl = "https://promoklocki.pl";
        Document mainPage = fetchDocument(baseUrl, 1);
        var lastPage = extractPageRange(mainPage);

//        IntStream.range(1, lastPage + 1).forEach(page -> {
        IntStream.range(1, 3).forEach(page -> {
            log.info("Scraping page: {}/{}", page, lastPage);
            var document = fetchDocument(baseUrl, page);
            document.select(".content > .product")
                    .forEach(product -> {
                        var title = titleExtractor.parseTitle(product.select("div > a").attr("title"));

                        var link = baseUrl + product.select("div > a").attr("href");

                        var smallImg = baseUrl + product.select("div > a > img").attr("src");
                        var mediumImg = smallImg.replace(".s", ".m");
                        var bigImg = smallImg.replace(".s", ".b");
                        var originalImg = smallImg.replace(".s", "");

                        //body > div.main > div > div:nth-child(3) > div:nth-child(3) > div.col-8.col-md-7.col-lg-8.align-self-center.text-left > span

//                        var descriptionText = product.select("div:nth-child(2) > p").text();

//                        System.out.println("descriptionText = " + descriptionText);

//                        var description = descriptionExtractor.parseDescription(descriptionText);
//                        var year = description.map(DescriptionExtractor.Description::year).orElse(0);
//                        var elements = description.map(DescriptionExtractor.Description::elements).orElse(0);
//                        var pricePerElement = description.map(DescriptionExtractor.Description::pricePerElement).orElse(BigDecimal.ZERO);
//                        var currency = description.map(DescriptionExtractor.Description::currency).orElse(null);
//                        var currentMinimalPrice = toDecimal(product.select("div:nth-child(3) > div > a > strong").text());

                        log.info("Scraped product details: \n{}", title.get().title() +
                                                                  "\n - " + title.get().company() +
                                                                  "\n - " + title.get().category() +
                                                                  "\n - " + title.get().setId() +
                                                                  "\n - " + link +
//                                           "\n - " + year +
//                                           "\n - " + elements +
//                                           "\n - " + pricePerElement + currency +
//                                           "\n - " + currentMinimalPrice +
                                                                  "\n - " + smallImg +
                                                                  "\n - " + mediumImg +
                                                                  "\n - " + bigImg +
                                                                  "\n - " + originalImg);
//                        System.out.println(title +
//                                           "\n - " + link +
//                                           "\n - " + year +
//                                           "\n - " + elements +
//                                           "\n - " + pricePerElement + currency +
//                                           "\n - " + currentMinimalPrice +
//                                           "\n - " + smallImg +
//                                           "\n - " + mediumImg +
//                                           "\n - " + bigImg +
//                                           "\n - " + originalImg
//                        );

                        productRepository.insert(new Product(
                                UUID.randomUUID(),
                                title.get().title(),
                                link,
//                                year,
//                                elements,
//                                pricePerElement,
//                                currency,
//                                currentMinimalPrice,
                                smallImg,
                                mediumImg,
                                bigImg,
                                originalImg
//                                ,
//                                descriptionText
                        ));
                    });
        });
    }

    private int extractPageRange(Document document) {
        var lastPageNumberStr = document.select("body > div.main > div > div:nth-child(4) > div > ul > li:nth-child(9) > a")
                .attr("href")
                .replaceFirst("\\?p=", "");

        return Integer.parseInt(lastPageNumberStr);
    }

    private Document fetchDocument(String baseUrl, int page) {
        // fetching the target website
        var pageQueryParam = "p=";

        try {
            return Jsoup.connect(baseUrl + "?" + pageQueryParam + page)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .header("Accept-Language", "*")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BigDecimal toDecimal(String text) {
        return text.isEmpty() ? BigDecimal.ZERO : new BigDecimal(text.replace(",", "."));
    }
}
