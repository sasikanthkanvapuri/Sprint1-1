package com.example.MiniProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MiniProject.dao.CustomerRepository;
import com.example.MiniProject.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomerInfo(int acctID) {
		return customerRepository.findById(acctID).orElse(null);
	}

	public void deleteCustomer(int acctID) {
		customerRepository.deleteById(acctID);
	}

}

