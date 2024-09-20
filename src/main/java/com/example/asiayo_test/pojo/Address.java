package com.example.asiayo_test.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Address {

  @NotBlank
  private String city;

  @NotBlank
  private String district;

  @NotBlank
  private String street;

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String toString() {
    return "city: " + city + "\n" + "district: " + district + "\n" + "street: " + street;
  }

}
