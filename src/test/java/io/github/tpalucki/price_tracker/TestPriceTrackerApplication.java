package io.github.tpalucki.price_tracker;

import org.springframework.boot.SpringApplication;

public class TestPriceTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.from(PriceTrackerApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }

}
