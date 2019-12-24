package com.DatasourceRouting.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.DatasourceRouting.enums.DBEnum;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.util.SuspendResumeLock;


@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties("spring.datasource")
public class DataSourceConfig extends HikariConfig   {
	
	//jdbc:jtds:sqlserver://TUL1MDDVWDE02/Cosmo;useNTLMv2=true;domain=CORPORATE

	
	@Value("#{${spring.urls}}")
	public Map<String,String> dbURL;

	/*
	 * DataSourceConfig(){
	 * 
	 * System.out.println("thisi is datasopurce configs"); }
	 * 
	 * 
	 * public DataSource CreateDataSource(String url) { //JdbcTemplate js=new
	 * JdbcTemplate(); //js.execute(""); DataSource ds=null;
	 * System.out.println("dbURl==="+dbURL.get("db1url")); try {
	 * DataSourceProperties dbprop= dataSourceProperties();
	 * dbprop.setUrl(dbURL.get("db1url"));
	 * 
	 * ds= dbprop.initializeDataSourceBuilder().type(HikariDataSource.class)
	 * .build(); }catch(Exception e ) { e.printStackTrace();} return ds; }
	 * 
	 * 
	 * 
	 * @Bean
	 * 
	 * @Primary // @ConfigurationProperties("spring.datasource") public
	 * DataSourceProperties dataSourceProperties() { return new
	 * DataSourceProperties(); }
	 * 
	 * 
	 * 
	 * @Bean public DataSource targetDataSources(){
	 * 
	 * AbstractRoutingDataSource routingdatasource=new RoutingDataSource();
	 * 
	 * DataSource db1=CreateDataSource(dbURL.get("db1url")); DataSource
	 * db2=CreateDataSource(dbURL.get("db2url"));
	 * 
	 * Map<Object,Object> targetDataSource=new HashMap<Object,Object>();
	 * targetDataSource.put("DB1",db1); targetDataSource.put("DB2",db2);
	 * routingdatasource.setTargetDataSources(targetDataSource);
	 * routingdatasource.afterPropertiesSet(); return routingdatasource; }
	 */
	
	
	
	
	@Bean
	public DataSource createDataSource(){
		HikariDataSource db1=null;
		HikariDataSource db2=null;
		AbstractRoutingDataSource routingdatasource=new RoutingDataSource();
		
		try {
			//this.setConnectionTestQuery("select 1");
			db1=new  HikariDataSource(createConfig(dbURL.get("db1url")));
			db2=new  HikariDataSource(createConfig(dbURL.get("db2url")));
			 
			Map<Object,Object> targetDataSource=new HashMap<Object,Object>();
		 
		 
		  targetDataSource.put(DBEnum.DB1,db1); 
		  targetDataSource.put(DBEnum.DB2,db2);
		  routingdatasource.setTargetDataSources(targetDataSource);
		  routingdatasource.afterPropertiesSet(); 
		   
		 
		 
		}catch(Exception e ) {
			e.printStackTrace();
		}
		 return routingdatasource;
	}
	
	@Bean
	public JdbcTemplate get() {
		return new JdbcTemplate(createDataSource());
	}
	
	
	public HikariConfig createConfig(String url){
		
		this.setJdbcUrl(url);
		return this;
	}
	
	

	@Primary
	  @Bean
	  public JdbcTemplate getJdbcTemplate()
	  {
		  return new JdbcTemplate(createDataSource());
	  }
	  
	  
	
}
