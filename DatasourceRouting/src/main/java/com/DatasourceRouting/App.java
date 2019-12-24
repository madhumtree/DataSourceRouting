package com.DatasourceRouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DatasourceRouting.ServiceImpl.CrudServiceImpl;
import com.DatasourceRouting.config.Config;
import com.DatasourceRouting.config.DBContextHolder;
import com.DatasourceRouting.config.DataSourceConfig;
import com.DatasourceRouting.enums.DBEnum;


//@SuppressWarnings("resource")
@SpringBootApplication
public class App 
{
	
//	@Autowired 
//	ApplicationContext applicationcontext;
	
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

		 //CrudServiceImpl crudserviceimpl=
		 
		  
		/*
		 * AnnotationConfigApplicationContext applicationcontext=new
		 * AnnotationConfigApplicationContext();
		 * 
		 * // applicationcontext.register(Config.class);
		 * applicationcontext.register(DataSourceConfig.class);
		 * applicationcontext.refresh();
		 * 
		 * DBContextHolder.setDBType(DBEnum.DB1); CrudServiceImpl obj=
		 * applicationcontext.getBean(CrudServiceImpl.class); obj.getdata();
		 */
    	//SpringApplication.run(App.class);
    	
    }
}
