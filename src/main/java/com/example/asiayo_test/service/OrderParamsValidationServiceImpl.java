package com.example.asiayo_test.service;

import com.example.asiayo_test.exception.InvalidCurrencyException;
import com.example.asiayo_test.exception.InvalidNameFormatException;
import com.example.asiayo_test.exception.PricingOutOfRangeException;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class OrderParamsValidationServiceImpl implements OrderParamsValidationService {

  @Override
  public boolean validateNameLetter(String name) throws InvalidNameFormatException {
    String trimmedName = name.replace(" ", "");
    if(trimmedName.matches("[a-zA-Z]*$")) {
      return true;
    } else {
      throw new InvalidNameFormatException("Name contains non-English characters");
    }
  }

  @Override
  public boolean validateNameFirstLetter(String name) throws InvalidNameFormatException {
    if(name.matches("^[A-Z].*")) {
      return true;
    } else {
      throw new InvalidNameFormatException("Name is not Capitalized");
    }
  }

  @Override
  public boolean validatePriceLimit(BigDecimal price) throws PricingOutOfRangeException {
    BigDecimal limit = new BigDecimal(2000);
    if(price.compareTo(limit) <= 0) {
      return true;
    } else {
      throw new PricingOutOfRangeException("Price is over 2000");
    }
  }

  @Override
  public boolean validateCurrency(String currency) throws InvalidCurrencyException {
    if(currency.equals("TWD") || currency.equals("USD")) {
      return true;
    } else {
      throw new InvalidCurrencyException("Currency format is wrong");
    }
  }
}
