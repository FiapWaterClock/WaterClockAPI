package br.com.waterclock.api;

import static com.jayway.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import br.com.waterclock.api.entity.Clock;
import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.TestPropertySource;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Clock.class)
@TestPropertySource(value = {"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class ClockAPIController {

    @Test
    public void getDataTest() {
        get("/api/tdd/responseData").then().assertThat().body("data", equalTo("responseData"));
    }

    @Before
    public void setBaseUri() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
    }
}
