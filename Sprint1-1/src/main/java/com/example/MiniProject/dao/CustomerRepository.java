package com.example.MiniProject.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.MiniProject.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
