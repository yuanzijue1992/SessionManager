package com.yuanzijue.parseconfig;

import java.util.Map;

public interface Mapper {
	
	// 获取id
	public String getId();
	
	// 获取表名
	public String getTableName();
	
	
	public String getClassName();
	
	// 获取字段-列对应映射
	// value是String代表着是数据库中的列名
	// value是Mapper代表着是一个数据库表
	public Map<String,Object> getProps();
	
	

}
