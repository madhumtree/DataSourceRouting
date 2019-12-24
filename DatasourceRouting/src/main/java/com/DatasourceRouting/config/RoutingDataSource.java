
  package com.DatasourceRouting.config;
  
  import java.util.Map;
  
  import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
  
  public class RoutingDataSource extends AbstractRoutingDataSource{
  
  
  
  @Override protected Object determineCurrentLookupKey() { 
	  // TODO Auto-generated method stub 
	  return DBContextHolder.getDBType(); 
	  }
  
	/*
	 * @Override public void setTargetDataSources(Map<Object, Object>
	 * targetDataSources) { // TODO Auto-generated method stub
	 * super.setTargetDataSources(targetDataSources); }
	 */
  
  
  }
 