package com.example.asiayo_test.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterImpl implements CurrencyConverter {

  @Override
  public BigDecimal convertUSDToTWD(BigDecimal amount) {
    return amount.multiply(new BigDecimal(31));
  }
}
