package com.yuanzijue.persistence;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	protected Map<String,String> tablemap = new HashMap<String ,String>();
	
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
        //注册类名数据库名对应表
        register();
        
	}

	
	/*
	 * 获取配置文件路径，有子类来实现
	 */
	protected abstract String filepath(Context context);
	
	/*
	 * 获取id，由子类来完成
	 */
	protected abstract void parseId();
	
	/*
	 * 解析table
	 */
	protected abstract void parseTables();

	protected abstract void register();

		
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public List<Table> getTables() {
		return tables;
	}
	
	@Override
	public File getConfigFile() {
		return file;
	}



	@Override
	public Element getRoot() {
		return root;
	}



	public void setRoot(Element root) {
		this.root = root;
	}
	
	@Override
	public Map getMap(){
		return tablemap;
	}
	
	
	
	

	
	
	
	

}
