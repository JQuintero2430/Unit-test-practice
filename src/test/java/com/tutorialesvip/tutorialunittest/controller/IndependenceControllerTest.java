package com.tutorialesvip.tutorialunittest.controller;

import com.tutorialesvip.tutorialunittest.models.Country;
import com.tutorialesvip.tutorialunittest.models.CountryResponse;
import com.tutorialesvip.tutorialunittest.repositories.CountryRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class IndependenceControllerTest {

    @Mock
    CountryRepository countryRepositoryMock;
    DiferenciaEntreFechas diferenciaEntreFechas;
    IndependenceController independenceController;

    @BeforeEach
    void setUp() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        independenceController = new IndependenceController(countryRepositoryMock, diferenciaEntreFechas);

        Country countryMock = new Country();
        countryMock.setCountryCapital("Santo Domingo");
        countryMock.setCountryIdependenceDate("27/02/1844");
        countryMock.setCountryName("República Dominicana");
        countryMock.setIsoCode("DO");
        countryMock.setCountryId(1L);

        Mockito.when(countryRepositoryMock.findCountryByIsoCode("DO")).thenReturn(countryMock);
    }

    @Test
    void getCountryDetails() {

        ResponseEntity<CountryResponse> controllerTested = independenceController.getCountryDetails("DO");
        CountryResponse countryResponse = controllerTested.getBody();
        assertNotNull(countryResponse);
        assertEquals("República Dominicana", Objects.requireNonNull(controllerTested.getBody()).getCountryName());
        assertEquals("Santo Domingo", Objects.requireNonNull(controllerTested.getBody()).getCapitalName());
        assertEquals("27/02/1844", Objects.requireNonNull(controllerTested.getBody()).getIndependenceDate());
        assertEquals(24, Objects.requireNonNull(controllerTested.getBody()).getDayssOfIndependency());
        assertEquals(8, Objects.requireNonNull(controllerTested.getBody()).getMonthsOfIndependency());
        assertEquals(179, Objects.requireNonNull(controllerTested.getBody()).getYearsOfIndependency());

    }

}