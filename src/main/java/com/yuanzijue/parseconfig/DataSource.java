package com.yuanzijue.parseconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom4j.Element;

public class DataSource {
	
	private String url;
	private String driver;
	private String user;
	private String password;
	
	private Connection conn=null;
	private Statement st=null;
	
	private Element root;
	
	public DataSource(Element root) {
		this.root=root;
		init();
	}
	
	public void init(){
		try{
			Element datasource = Parse.parseElement(root, "DataSource");
			url = Parse.parseAttribute(datasource, "url");
			driver = Parse.parseAttribute(datasource, "driver");
			user = Parse.parseAttribute(datasource, "user");
			password = Parse.parseAttribute(datasource, "password");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user,password);
			st=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Statement getStatement(){
		return st;
	}
	

}
