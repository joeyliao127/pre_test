package com.example.asiayo_test.pojo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OrderPOJO {


  @NotBlank
  private String id;

  @NotBlank
  private String name;

  @NotNull
  @Valid
  private Address address;

  @NotNull
  @Min(1)
  private BigDecimal price;

  @NotBlank
  private String currency;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String toString() {
    return "id: " + id + "\n" + "name: " + name + "\n" + "Address: " + address.toString() + "\n" + "price: " + price + "\n" + "currency: " + currency;

  }
}
