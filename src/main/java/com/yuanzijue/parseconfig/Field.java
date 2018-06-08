package com.yuanzijue.parseconfig;

import java.sql.Date;

import org.dom4j.Element;
import org.hamcrest.core.IsInstanceOf;

import com.yuanzijue.persistence.exception.NoSuchAttributeException;
import com.yuanzijue.persistence.exception.UnknowFidleException;




public class Field {
	
	public static int INT=1;
	
	public static int STRING=2;
	
	public static int LONG=3;
	
	public static int BOOLEAN=4;
	
	public static int DATE = 5;
	
	public static int FLOAT = 6;
	
	private String key;
	
	private String column;
	
	private boolean isTable=false;
	
	private Table table;
	
	private String classname;
	
	
	public Field(){
		
	}
		
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getColumn() {
		return column;
	}


	public void setColumn(String column) {
		this.column = column;
	}

	

	public boolean getIsTable() {
		return isTable;
	}

	public void setIsTable(boolean isTable) {
		this.isTable = isTable;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	
	
	

}
