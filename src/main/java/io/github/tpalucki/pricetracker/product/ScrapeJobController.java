package io.github.tpalucki.pricetracker.product;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScrapeJobController {

    private final ScraperService scraperService;

    public ScrapeJobController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @GetMapping("/scrape")
    void runScrapeJob() {
        scraperService.scrape();
    }
}
