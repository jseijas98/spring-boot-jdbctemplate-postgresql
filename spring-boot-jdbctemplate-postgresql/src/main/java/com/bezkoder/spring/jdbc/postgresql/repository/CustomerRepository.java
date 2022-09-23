package com.bezkoder.spring.jdbc.postgresql.repository;

import java.util.List;

import com.bezkoder.spring.jdbc.postgresql.model.Customer;


public interface CustomerRepository {



  Customer findById(Long id);

  int deleteById(Long id);

  List<Customer> findAll();

  List<Customer> findByTitleContaining(String name);

  void save(Customer customer);

  void update(Customer customer);

  int deleteAll();

}
