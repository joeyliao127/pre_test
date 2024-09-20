package com.example.asiayo_test.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CurrencyConverterImplTest {

  @Autowired
  private CurrencyConverter currencyConverter;

  @Test
  public void testConvertUSDToTWD() {
    BigDecimal result1 = this.currencyConverter.convertUSDToTWD(new BigDecimal(100));
    BigDecimal expected1 = new BigDecimal(3100);
    BigDecimal expected2 = new BigDecimal(3500);
    assertEquals(expected1, result1);
    assertNotEquals(expected2, result1);
  }
}