package com.evelynda1985.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evelynda1985.crm.dao.CustomerDAO;
import com.evelynda1985.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject customer DAO
	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional//avoid to write session.begin and session.getCurrentSession.commit
	public List<Customer> getCustomers() {
		return customerDao.getCustomer();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDao.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		return customerDao.updateCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);		
	}

}
