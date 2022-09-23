package com.bezkoder.spring.jdbc.postgresql.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jdbc.postgresql.model.Customer;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void save(Customer customer) {
    jdbcTemplate.update("INSERT INTO customers (name, lastname) VALUES(?,?)",
            customer.getName(), customer.getLastName());
  }

  @Override
  public void update(Customer customer) {
    jdbcTemplate.update("UPDATE customers SET name=?, lastname=? WHERE id=?",
            customer.getName(), customer.getLastName(), customer.getId());
  }

  @Override
  public int deleteAll() {
    return jdbcTemplate.update("DELETE from customers");
  }

  @Override
  public Customer findById(Long id) {
    try {

      return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE id=?",
            BeanPropertyRowMapper.newInstance(Customer.class), id);
    } catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  @Override
  public int deleteById(Long id) {
    return jdbcTemplate.update("DELETE FROM customers WHERE id=?", id);
  }

  @Override
  public List<Customer> findAll() {
    return jdbcTemplate.query("SELECT * from customers", BeanPropertyRowMapper.newInstance(Customer.class));
  }

  @Override
  public List<Customer> findByTitleContaining(String title) {
    String q = "SELECT * from customers WHERE title ILIKE '%" + title + "%'";

    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Customer.class));
  }

}
