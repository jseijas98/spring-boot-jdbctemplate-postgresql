package com.bezkoder.spring.jdbc.postgresql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  private long id;
  private String name;
  private String lastName;


  public Customer (String name, String lastName) {
    this.name = name;
    this.lastName = lastName;

  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + name + ", desc=" + lastName +"]";
  }

}
