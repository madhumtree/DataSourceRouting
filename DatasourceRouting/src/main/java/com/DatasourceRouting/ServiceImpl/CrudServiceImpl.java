package com.DatasourceRouting.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl {
   
	@Autowired
	public JdbcTemplate jdbctemplate;
	
	
	public CrudServiceImpl() {
		
	}
	
	public void getdata() {
		String Query="SELECT COUNT(*) FROM Cosmo.dbo.Canary";
		Integer s=jdbctemplate.queryForObject(Query, Integer.class);
		
		System.out.println(s);
		//sreturn "Hello";
		
	}
	
}
