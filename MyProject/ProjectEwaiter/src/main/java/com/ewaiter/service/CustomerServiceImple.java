package com.ewaiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaiter.dao.CustomerRepository;
import com.ewaiter.dto.Customer;

@Service
public class CustomerServiceImple implements CustomerService {

	@Autowired
	CustomerRepository crepo;
	
	@Override
	public boolean custLoginService(Customer customer) {
		boolean flag = false;
		flag = crepo.custLoginRepo(customer);
		return flag;
	}

}
