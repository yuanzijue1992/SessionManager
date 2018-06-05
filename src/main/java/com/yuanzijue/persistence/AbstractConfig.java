package com.yuanzijue.persistence;

import java.io.File;
import java.util.List;

import org.apache.catalina.Context;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public abstract class AbstractConfig implements Config{
	
	protected String id;
	
	protected List<Table> tables;
	
	protected File file;
	
	protected Context context;
	
	protected Element root;
	
	public AbstractConfig(Context context) {
		this.context=context;
		// 获取配置文件
		file=new File(filepath(context));
		SAXReader saxReader = new SAXReader();
        Document document=null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取根节点
        root = document.getRootElement();
        //解析id
        parseId();
        //解析tables
        parseTables();
        
	}

	

	protected abstract String filepath(Context context);
	
	/*
	 * 获取id，由子类来完成
	 */
	protected abstract void parseId();
	
	/*
	 * 解析table
	 */
	protected abstract void parseTables();

	/*
	 * 获取配置文件路径，有子类来实现
	 */

		
	@Override
	public Object getId() {
		return id;
	}
	
	@Override
	public List<Table> getTables() {
		return tables;
	}
	
	@Override
	public File getConfigFile(Context context) {
		return file;
	}
	
	

	
	
	
	

}
