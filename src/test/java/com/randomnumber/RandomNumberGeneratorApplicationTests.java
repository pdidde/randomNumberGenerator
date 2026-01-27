package com.randomnumber;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RandomNumberGeneratorApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	void testGenerateRandomNumber() {
		when()
			.get("/api/random/generate?requester=testuser")
		.then()
			.statusCode(200)
			.body("random_number", greaterThanOrEqualTo(1000))
			.body("random_number", lessThan(10000))
			.body("generated_at", greaterThan(0L));
	}

	@Test
	void testGenerateRandomNumberMultipleTimes() {
		// Verify the endpoint returns valid 4-digit numbers in multiple calls
		for (int i = 0; i < 5; i++) {
			when()
				.get("/api/random/generate?requester=testuser")
			.then()
				.statusCode(200)
				.body("random_number", allOf(
					greaterThanOrEqualTo(1000),
					lessThan(10000)
				));
		}
	}

	@Test
	void testResponseContentType() {
		when()
			.get("/api/random/generate?requester=testuser")
		.then()
			.statusCode(200)
			.contentType("application/json");
	}

}
