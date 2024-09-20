package com.example.asiayo_test.service;

import com.example.asiayo_test.dto.OrderDTO;
import com.example.asiayo_test.exception.InvalidCurrencyException;
import com.example.asiayo_test.exception.InvalidNameFormatException;
import com.example.asiayo_test.exception.PricingOutOfRangeException;
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
  public OrderDTO transformOrder(OrderPOJO orderPOJO)
      throws InvalidNameFormatException, PricingOutOfRangeException, InvalidCurrencyException {

    this.validateOrderParams(orderPOJO.getName(), orderPOJO.getPrice(), orderPOJO.getCurrency());

    OrderDTO orderDTO = new OrderDTO();

    orderDTO.setId(orderPOJO.getId());
    orderDTO.setName(orderPOJO.getName());
    orderDTO.setAddress(orderPOJO.getAddress());

    String currency = orderPOJO.getCurrency();
    if(currency.equals("USD")) {
      BigDecimal price = orderPOJO.getPrice();
      BigDecimal transformedPrice = this.currencyConverter.convertUSDToTWD(price);

      if(!this.validationService.validatePriceLimit(transformedPrice)) {
        throw new PricingOutOfRangeException("Price is over 2000");
      }

      orderDTO.setPrice(transformedPrice);
      orderDTO.setCurrency("TWD");
    } else {
      orderDTO.setCurrency(orderPOJO.getCurrency());
      orderDTO.setPrice(orderPOJO.getPrice());
    }

    return orderDTO;
  }

  private void validateOrderParams(String name, BigDecimal price, String currency)
      throws InvalidNameFormatException, InvalidCurrencyException, PricingOutOfRangeException {
    this.validationService.validateNameLetter(name);
    this.validationService.validateNameFirstLetter(name);
    this.validationService.validatePriceLimit(price);
    this.validationService.validateCurrency(currency);
  }
}
