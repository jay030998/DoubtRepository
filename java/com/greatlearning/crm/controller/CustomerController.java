package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.crm.model.Customer;
import com.greatlearning.crm.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		//get  customer from db
		
		List<Customer> customers = customerService.findAll();
		
		//add to the spring model
		theModel.addAttribute(customers);
		return "customer-list";
	}
}
