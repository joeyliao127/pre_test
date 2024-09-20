package com.example.asiayo_test.service;

import java.math.BigDecimal;

public interface OrderParamsValidationService {
  boolean validateNameLetter(String name);
  boolean validateNameFirstLetter(String name);
  boolean validatePriceLimit(BigDecimal price);
  boolean validateCurrency(String currency);
}
