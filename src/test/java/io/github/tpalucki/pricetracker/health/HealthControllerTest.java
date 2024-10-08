package io.github.tpalucki.pricetracker.health;

import io.github.tpalucki.pricetracker.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpMethod.GET;


class HealthControllerTest extends IntegrationTest {

    @Test
    void healthCheckReturnsOk() {
        var response = restTemplate
                .exchange(baseUrl() + "/health", GET, HttpEntity.EMPTY, String.class)
                .getBody();

        assertEquals("""
                {
                    "status": "UP"
                }
                """, response);
    }
}