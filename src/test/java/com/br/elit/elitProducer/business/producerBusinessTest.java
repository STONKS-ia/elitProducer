package com.br.elit.elitProducer.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class producerBusinessTest {

    @InjectMocks
    public ProducerBusiness producerBusiness;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testClassifyPh() {

        // GIVEN
        BigDecimal ph = BigDecimal.TEN;
        String expected = "Alcalino";

        // WHEN
        String actual = producerBusiness.classifyPh(ph);

        // THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testClassifyTurbity() {

        // GIVEN
        Double turbity = 100.0;
        String expected = "Agua limpa";

        // WHEN
        String actual = producerBusiness.classifyTurbity(turbity);

        // THEN
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testClassifyAlkalinity() {

        // GIVEN
        Double alkalinity = 100.0;
        String expected = "Boa capacidade tampao";

        // WHEN
        String actual = producerBusiness.classifyAlkalinity(alkalinity);

        // THEN
        Assertions.assertEquals(expected, actual);
    }

}
