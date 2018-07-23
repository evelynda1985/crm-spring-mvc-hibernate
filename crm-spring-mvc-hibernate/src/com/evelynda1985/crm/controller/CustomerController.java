package com.evelynda1985.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evelynda1985.crm.entity.Customer;
import com.evelynda1985.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject customer service from the service no from the DAO as before
	@Autowired CustomerService customerService;
	
	//@RequestMapping
	//@PostMapping
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customer from the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customer to the service
		theModel.addAttribute("Customers", theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("showFormAdd")
	public String showFormAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {	
		
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId,
								 Model theModel) {
		
		//get customer from the service
		Customer theCustomer = customerService.getCustomers(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//Delete customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}

}
