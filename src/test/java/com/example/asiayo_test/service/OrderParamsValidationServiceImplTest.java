package com.example.asiayo_test.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.asiayo_test.exception.InvalidCurrencyException;
import com.example.asiayo_test.exception.InvalidNameFormatException;
import com.example.asiayo_test.exception.PricingOutOfRangeException;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderParamsValidationServiceImplTest {

  @Autowired
  private OrderParamsValidationServiceImpl validationService;

  @Test
  public void testValidateNameLetter() throws InvalidNameFormatException {
    String case1 = "abc def";
    boolean result1 = validationService.validateNameLetter(case1);
    assertTrue(result1);

    String case2 = "ONE1";
    assertThrows(InvalidNameFormatException.class, ()->{
      validationService.validateNameLetter(case2);
    });

    String case3 = "Lisa Yang";
    boolean result3 = validationService.validateNameLetter(case3);
    assertTrue(result3);

    String case4 = "@test";
    assertThrows(InvalidNameFormatException.class, ()->{
      validationService.validateNameLetter(case4);
    });
  }

  @Test
  public void testValidateNameFirstLetter() throws InvalidNameFormatException {
    String case1 = "Ace";
    boolean result1 = validationService.validateNameFirstLetter(case1);
    assertTrue(result1);

    String case2 = "abcd";
    assertThrows(InvalidNameFormatException.class, ()->{
      validationService.validateNameFirstLetter(case2);
    });

    String case3 = "Lisa Yang";
    boolean result3 = validationService.validateNameFirstLetter(case3);
    assertTrue(result3);

    String case4 = "@test";
    assertThrows(InvalidNameFormatException.class, ()->{
      validationService.validateNameFirstLetter(case4);
    });
  }

  @Test
  public void testValidatePriceLimit() throws PricingOutOfRangeException {
    BigDecimal case1 = new BigDecimal(1000);
    boolean result1 = validationService.validatePriceLimit(case1);
    assertTrue(result1);

    BigDecimal case2 = new BigDecimal(2000);
    boolean result2 = validationService.validatePriceLimit(case2);
    assertTrue(result2);

    BigDecimal case3 = new BigDecimal(3000);
    assertThrows(PricingOutOfRangeException.class, ()->{
      validationService.validatePriceLimit(case3);
    });

    BigDecimal case4 = new BigDecimal(4000);
    assertThrows(PricingOutOfRangeException.class, ()->{
      validationService.validatePriceLimit(case4);
    });

    BigDecimal case5 = new BigDecimal(0);
    boolean result5 = validationService.validatePriceLimit(case5);
    assertTrue(result5);
  }

  @Test
  public void testValidateCurrency() throws InvalidCurrencyException {
    String case1 = "TWD";
    boolean result1 = validationService.validateCurrency(case1);
    assertTrue(result1);

    String case2 = "USD";
    boolean result2 = validationService.validateCurrency(case2);
    assertTrue(result2);

    String case3 = "JPY";
    assertThrows(InvalidCurrencyException.class, ()->{
      validationService.validateCurrency(case3);
    });

    String case4 = "EUR";
    assertThrows(InvalidCurrencyException.class, ()->{
      validationService.validateCurrency(case4);
    });

  }


}