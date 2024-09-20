package com.example.asiayo_test.exception;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrdersExceptionHandler {

  @ExceptionHandler(InvalidNameFormatException.class)
  public ResponseEntity<Object> invalidNameFormatException(InvalidNameFormatException exception) {
    return ResponseEntity.status(400).body(Map.of("message", exception.getMessage()));
  }

  @ExceptionHandler(InvalidCurrencyException.class)
  public ResponseEntity<Object> invalidCurrencyException(InvalidCurrencyException exception) {
    return ResponseEntity.status(400).body(Map.of("message", exception.getMessage()));
  }

  @ExceptionHandler(PricingOutOfRangeException.class)
  public ResponseEntity<Object> pricingOutOfRangeException(PricingOutOfRangeException exception) {
    return ResponseEntity.status(400).body(Map.of("message", exception.getMessage()));
  }

}
