package com.example.asiayo_test.exception;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class OrdersExceptionHandler {

  @ExceptionHandler(InvalidNameFormatException.class)
  public ResponseEntity<Object> invalidNameFormatException(InvalidNameFormatException exception) {
    log.warn(exception.getMessage());
    return ResponseEntity.status(400).body(Map.of("message", exception.getMessage()));
  }

  @ExceptionHandler(InvalidCurrencyException.class)
  public ResponseEntity<Object> invalidCurrencyException(InvalidCurrencyException exception) {
    log.warn(exception.getMessage());
    return ResponseEntity.status(400).body(Map.of("message", exception.getMessage()));
  }

  @ExceptionHandler(PricingOutOfRangeException.class)
  public ResponseEntity<Object> pricingOutOfRangeException(PricingOutOfRangeException exception) {
    log.warn(exception.getMessage());
    return ResponseEntity.status(400).body(Map.of("message", exception.getMessage()));
  }

}
