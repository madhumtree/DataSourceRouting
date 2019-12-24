package com.DatasourceRouting.config;

import org.springframework.util.Assert;

import com.DatasourceRouting.enums.DBEnum;

public class DBContextHolder {
	
	  private static final ThreadLocal<DBEnum> contextHolder = new
	  ThreadLocal<DBEnum>();
	  
	  public static void setDBType(DBEnum dbname) { Assert.notNull(dbname,
	  "customerType cannot be null"); contextHolder.set(dbname); }
	  
	  public static Object getDBType() {
		  return  contextHolder.get(); }
	  
	  public static void clearDBType() { contextHolder.remove(); }
	 
}
