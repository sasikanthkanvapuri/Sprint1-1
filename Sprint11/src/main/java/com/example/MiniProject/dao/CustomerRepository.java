package com.example.MiniProject.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MiniProject.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByacctIDAndPassword(int acctID, String password);
	

}
