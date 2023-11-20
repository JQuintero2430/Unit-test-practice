package com.tutorialesvip.tutorialunittest.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DiferenciaEntreFechasTest {

    @Autowired
    private DiferenciaEntreFechas diferenciaEntreFechas;
    @Test
    void calculateYearsOfIndependenceTest(){
        //Arrange
        String independenceDay = "20/11/1823";
        //Act
        Period result = diferenciaEntreFechas.calculateYearsOfIndependence(independenceDay);
        //Assert
        assertEquals(200, result.getYears());
        assertEquals(0, result.getMonths());
        assertEquals(0, result.getDays());

    }

}