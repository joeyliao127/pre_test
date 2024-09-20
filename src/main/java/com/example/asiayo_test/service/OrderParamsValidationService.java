package com.example.asiayo_test.service;

import java.math.BigDecimal;

public interface OrderParamsValidationService {
  void validateName(String name);
  void validatePrice(BigDecimal price);
  void validateCurrency(String currency);
}
