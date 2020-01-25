package com.ewaiter.dao;

import com.ewaiter.dto.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImple implements UserRepository {
	
	@Autowired
	private JdbcTemplate jdbctemp;
	
	//login method will get the single user data from database with provided user name and password and compare it with data passed to it.
	//If data is matching "true" is returned ,else "false" is returned which is stored in boolean variable test.
	
	public int login(User user)
	{

		//
		
		String sql = "select * from user where user_name=? and password=?";
		User myuser = (User)jdbctemp.queryForObject(sql,new Object[] {user.getUser_name(),user.getPassword()},new UserRowMapper());
		boolean test = false;		
				test = myuser.getPassword().equals(user.getPassword()) && myuser.getUser_name().equals(user.getUser_name());
		
		//If test is "true" then control will go inside if condition.
		//If test is "false" then directly "0" is returned.
				
		if(test)
		{
			//If user matches and value of user_type_id of that user is "1" then value returned will be "1" as type user type ADMIN.		
			if(myuser.getUser_type_id()==1)
				return 1;
			
			//If user matches and value of user_type_id of that user is "2" then value returned will be "2" as type user type MANAGER.		
			if(myuser.getUser_type_id()==2)
				return 2;
			
			//else "3" is returned as type employee.
			else
				return 3;
		}
		else
			return 0;
		
	}

	@Override
	public boolean register(User user) {
		if(user.getName().equals(null)||user.getPassword().equals(null)||user.getName().equals(null)|| user.getSalary()==0||user.getUser_type_id()==0)
			return false;
		
		String sql = "insert into user(user_name,password,name,salary,user_type_id)values(?,?,?,?,?)";
		int records = jdbctemp.update(sql,new Object[] {user.getUser_name(),user.getPassword(),user.getName(),user.getSalary(),user.getUser_type_id()});
		if(records!=0)
			return true;
		else
			return false;
	}


	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
        List<User> li = jdbctemp.query(sql,new UserRowMapper());
		return li;
	}

	@Override
	public void removeUser(int id) {

		    String sql="delete from user where user_id=?";  
		    jdbctemp.update(sql, id );
	}

	//It will update the user in database with new values from myuser.
	
	@Override
	public void editUser(User myuser) {
		String mysql="update user set user_name=?,password =?,name=?,salary=?,user_type_Id=? where user_id=?";  
		jdbctemp.update(mysql,myuser.getUser_name(),myuser.getPassword(),myuser.getName(),myuser.getSalary(),myuser.getUser_type_id(),myuser.getUser_id());
	}

	@Override
	public User getUser(int id) {
		
		String sql = "select * from user where user_id=?";
		User myuser = (User)jdbctemp.queryForObject(sql,new Object[] {id},new UserRowMapper());
		return myuser;
	}
}
