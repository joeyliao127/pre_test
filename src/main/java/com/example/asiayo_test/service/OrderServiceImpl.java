package com.example.asiayo_test.service;

import com.example.asiayo_test.dto.OrderDTO;
import com.example.asiayo_test.pojo.OrderPOJO;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderParamsValidationService validationService;
  private final CurrencyConverter currencyConverter;

  public OrderServiceImpl(OrderParamsValidationService validationService,
      CurrencyConverter currencyConverter) {
    this.validationService = validationService;
    this.currencyConverter = currencyConverter;
  }

  @Override
  public OrderDTO transformOrder(OrderPOJO orderPOJO) {

  }
}
