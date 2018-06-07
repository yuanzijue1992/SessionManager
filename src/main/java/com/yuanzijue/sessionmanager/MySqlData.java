package com.yuanzijue.sessionmanager;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

import org.apache.catalina.Session;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.yuanzijue.persistence.AbstractConfig;
import com.yuanzijue.persistence.Config;

public class MySqlData extends AbstractData{
	private String  url;
	private String  driver;
	private String  user;
	private String  password;
	private Connection conn=null;
	private Statement st=null;
	
	
	
	public MySqlData(Config config) {
		super(config);
	}
	
	protected void init(){		
		
		// 获取DataSource
		getDataSource();
		
		try {
			Class.forName("url");
			conn= DriverManager.getConnection(url,user,password);
			st=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

//		st=conn.createStatement();//创建执行类
//		String sqldb="use mysql";
//		st.executeQuery(sqldb);//执行sql操作
//		String sql="select host,user from user";
//		rs=st.executeQuery(sql);//回去结果
//		while(rs.next())//查询结果
//			{
//				System.out.print(rs.getString("host")+" :: ");
//				System.out.println(rs.getString("user"));
//			}
	}
	
	@Override
	protected void saveSession(String key,Object value){
		
		String id = config.getId();
		String tablename = (String) config.getMap().get(value.getClass().getName());
		String sql = "insert into "+tablename;
		
		
	}
	
	@Override
	protected void getSession(String id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	// 根据配置文件初始化数据库链接信息
	private void getDataSource(){
		Element root = config.getRoot();
		Element datasource = root.element("DataSource");
		if(datasource==null) throw new NoSuchElementException();
		
		// 获取url
		Element url = datasource.element("url");
		if(url==null) throw new NoSuchElementException();
		this.url=url.getTextTrim();
		// 获取driver
		Element driver = datasource.element("driver");
		if(driver==null) throw new NoSuchElementException();
		this.driver=driver.getTextTrim();
		// 获取user
		Element user = datasource.element("user");
		if(user==null) throw new NoSuchElementException();
		this.user=user.getTextTrim();
		// 获取password
		Element password = datasource.element("password");
		if(password==null) throw new NoSuchElementException();
		this.password=password.getTextTrim();
		
		
	}

	

}
