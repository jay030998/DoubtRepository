package com.greatlearning.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import com.greatlearning.crm.model.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Customer findById(int id);

	void save(Customer theCustomer);

	void deleteById(int theId);

}