package com.yuanzijue.persistence;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Context;
import org.dom4j.Element;

/*
 * 这个接口指定了解析配置文件所需实现的必要功能
 */
public interface Config {
	
	/*
	 * 获取session的标识，一般为jsessionid
	 * 
	 * <id>key</id>
	 */
	public String getId();
	
	public Element getRoot();
	
	/*
	 * 通过xml获取表
	 */
	public List<Table> getTables();
	
	public File getConfigFile();
	
	public Map getMap();
	

}
