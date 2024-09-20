package com.example.asiayo_test.service;

import java.math.BigDecimal;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class OrderParamsValidationServiceImpl implements OrderParamsValidationService {

  @Override
  public void validateName(String name) {

  }

  @Override
  public void validatePrice(BigDecimal price) {

  }

  @Override
  public void validateCurrency(String currency) {

  }
}
