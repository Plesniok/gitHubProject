package com.dlesniok.githubproject.controllers;

import com.dlesniok.githubproject.models.github.UserRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GitHubControllerTest {


    @LocalServerPort
    private Integer randomServerPort;

    private RestClient testRestClient;

    @Autowired
    private MockMvc mockMvc;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH%3Amm%3Ass.SSS'Z'");

    private OffsetDateTime firstDate;
    private OffsetDateTime secondDate;
    private OffsetDateTime thirdDate;
    private OffsetDateTime fourthDate;

    @BeforeAll
    void setup() {

        testRestClient = RestClient.create("http://localhost:" + randomServerPort);
    }

    @Test
    @Order(1)
    void shouldGetUserRepos() {


        ResponseEntity<List<UserRepo>> carEventResponse = testRestClient.get()
                .uri("/git/plesniok/repos")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<UserRepo>>() {});

        assertNotNull(carEventResponse);
        assertEquals(HttpStatus.OK, carEventResponse.getStatusCode());
    }


}