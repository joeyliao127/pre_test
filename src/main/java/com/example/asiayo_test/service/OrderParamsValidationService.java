package com.example.asiayo_test.service;

import com.example.asiayo_test.exception.InvalidCurrencyException;
import com.example.asiayo_test.exception.InvalidNameFormatException;
import com.example.asiayo_test.exception.PricingOutOfRangeException;
import java.math.BigDecimal;

public interface OrderParamsValidationService {
  boolean validateNameLetter(String name) throws InvalidNameFormatException;
  boolean validateNameFirstLetter(String name) throws InvalidNameFormatException;
  boolean validatePriceLimit(BigDecimal price) throws PricingOutOfRangeException;
  boolean validateCurrency(String currency) throws InvalidCurrencyException;
}
