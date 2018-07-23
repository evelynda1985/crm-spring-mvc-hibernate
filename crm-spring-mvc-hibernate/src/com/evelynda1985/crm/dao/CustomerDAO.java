package com.evelynda1985.crm.dao;

import java.util.List;

import com.evelynda1985.crm.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

	public Customer updateCustomer(int theId);

	public void deleteCustomer(int theId);

}
