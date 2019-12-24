package com.DatasourceRouting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DatasourceRouting.ServiceImpl.CrudServiceImpl;
import com.DatasourceRouting.config.DBContextHolder;
import com.DatasourceRouting.enums.DBEnum;

@RestController
public class CrudController {

	@Autowired
	CrudServiceImpl crudserviceimpl;
	

	@RequestMapping(value="/getval")
public String get() {
		System.out.println();
		DBContextHolder.setDBType(DBEnum.DB1);
		crudserviceimpl.getdata();
		return "hello";
	}
}
