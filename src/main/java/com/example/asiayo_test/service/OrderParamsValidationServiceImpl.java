package com.example.asiayo_test.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class OrderParamsValidationServiceImpl implements OrderParamsValidationService {

  @Override
  public boolean validateNameLetter(String name) {
    String trimmedName = name.replace(" ", "");
    return trimmedName.matches("[a-zA-Z]*$");
  }

  @Override
  public boolean validateNameFirstLetter(String name) {
    return name.matches("^[A-Z].*");
  }

  @Override
  public boolean validatePriceLimit(BigDecimal price){
    BigDecimal limit = new BigDecimal(2000);
    return price.compareTo(limit) <= 0;
  }

  @Override
  public boolean validateCurrency(String currency) {
    return currency.equals("TWD") || currency.equals("USD");
  }
}
