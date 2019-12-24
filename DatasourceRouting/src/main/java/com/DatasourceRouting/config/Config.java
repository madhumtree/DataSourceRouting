package com.DatasourceRouting.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import com.DatasourceRouting.ServiceImpl.DaoImpl;

@ComponentScan("com.DatasourceRouting.*")
@Configuration
public class Config {

	Config(){
		System.out.println("==");
	}
	
	
}
