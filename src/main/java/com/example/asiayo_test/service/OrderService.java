package com.example.asiayo_test.service;

import com.example.asiayo_test.dto.OrderDTO;
import com.example.asiayo_test.exception.InvalidCurrencyException;
import com.example.asiayo_test.exception.InvalidNameFormatException;
import com.example.asiayo_test.exception.PricingOutOfRangeException;
import com.example.asiayo_test.pojo.OrderPOJO;

public interface OrderService {
  OrderDTO transformOrder(OrderPOJO orderPOJO)
      throws InvalidNameFormatException, PricingOutOfRangeException, InvalidCurrencyException;
}
