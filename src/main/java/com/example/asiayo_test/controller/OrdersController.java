package com.example.asiayo_test.controller;

import com.example.asiayo_test.dto.OrderDTO;
import com.example.asiayo_test.exception.InvalidCurrencyException;
import com.example.asiayo_test.exception.InvalidNameFormatException;
import com.example.asiayo_test.exception.PricingOutOfRangeException;
import com.example.asiayo_test.pojo.OrderPOJO;
import com.example.asiayo_test.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

  private OrderService orderService;

  public OrdersController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/api/orders")
  public ResponseEntity<OrderDTO> transformCurrency(@Valid @RequestBody OrderPOJO orderPOJO)
      throws InvalidNameFormatException, PricingOutOfRangeException, InvalidCurrencyException {
    OrderDTO orderDTO = orderService.transformOrder(orderPOJO);
    return ResponseEntity.status(200).body(orderDTO);
  }
}
