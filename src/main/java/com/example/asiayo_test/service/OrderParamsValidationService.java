package com.example.asiayo_test.service;

import java.math.BigDecimal;

public interface OrderParamsValidationService {
  boolean validateNameLetter(String name);
  boolean validateNameStart(String name);
  boolean validatePrice(BigDecimal price);
  boolean validateCurrency(String currency);
}
