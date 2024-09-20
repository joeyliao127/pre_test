package com.example.asiayo_test.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderParamsValidationServiceImplTest {

  @Autowired
  private OrderParamsValidationServiceImpl validationService;

  @Test
  public void testValidateNameLetter() {
    String case1 = "abc def";
    boolean result1 = validationService.validateNameLetter(case1);
    assertTrue(result1);

    String case2 = "ONE1";
    boolean result2 = validationService.validateNameLetter(case2);
    assertFalse(result2);

    String case3 = "Lisa Yang";
    boolean result3 = validationService.validateNameLetter(case3);
    assertTrue(result3);

    String case4 = "@test";
    boolean result4 = validationService.validateNameLetter(case4);
    assertFalse(result4);
  }

  @Test
  public void testValidateNameFirstLetter() {
    String case1 = "Ace";
    boolean result1 = validationService.validateNameFirstLetter(case1);
    assertTrue(result1);

    String case2 = "abcd";
    boolean result2 = validationService.validateNameFirstLetter(case2);
    assertFalse(result2);

    String case3 = "Lisa Yang";
    boolean result3 = validationService.validateNameFirstLetter(case3);
    assertTrue(result3);

    String case4 = "@test";
    boolean result4 = validationService.validateNameFirstLetter(case4);
    assertFalse(result4);
  }

  @Test
  public void testValidatePriceLimit() {
    BigDecimal case1 = new BigDecimal(1000);
    boolean result1 = validationService.validatePriceLimit(case1);
    assertTrue(result1);

    BigDecimal case2 = new BigDecimal(2000);
    boolean result2 = validationService.validatePriceLimit(case2);
    assertTrue(result2);

    BigDecimal case3 = new BigDecimal(3000);
    boolean result3 = validationService.validatePriceLimit(case3);
    assertFalse(result3);

    BigDecimal case4 = new BigDecimal(4000);
    boolean result4 = validationService.validatePriceLimit(case4);
    assertFalse(result4);

    BigDecimal case5 = new BigDecimal(0);
    boolean result5 = validationService.validatePriceLimit(case5);
    assertTrue(result5);
  }

  @Test
  public void testValidateCurrency() {
    String case1 = "TWD";
    boolean result1 = validationService.validateCurrency(case1);
    assertTrue(result1);

    String case2 = "USD";
    boolean result2 = validationService.validateCurrency(case2);
    assertTrue(result2);

    String case3 = "JPY";
    boolean result3 = validationService.validateCurrency(case3);
    assertFalse(result3);

    String case4 = "EUR";
    boolean result4 = validationService.validateCurrency(case4);
    assertFalse(result4);
  }


}