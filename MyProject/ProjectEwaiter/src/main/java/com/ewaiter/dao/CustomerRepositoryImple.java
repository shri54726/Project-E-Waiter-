package com.ewaiter.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ewaiter.dto.Customer;

@Repository
public class CustomerRepositoryImple implements CustomerRepository {

	@Autowired
	JdbcTemplate jdbctemp;
	
	@Override
	public boolean custLoginRepo(Customer customer) {
		
		if(customer.getName().equals("")||(customer.getTable_id()==0)||customer.getMobile_no().equals(""))
			return false;
		String sql = "insert into customer (name,table_id,mobile_no) values(?,?,?)";
		int records = jdbctemp.update(sql,new Object[] {customer.getName(),customer.getTable_id(),customer.getMobile_no()});
		if(records!=0)
			return true;
		else
			return false;
	}

}
