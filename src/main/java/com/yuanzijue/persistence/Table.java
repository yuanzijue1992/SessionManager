package com.yuanzijue.persistence;

import java.util.List;

import org.dom4j.Element;

import com.yuanzijue.persistence.exception.NoSuchAttributeException;
import com.yuanzijue.persistence.exception.UnknowFidleException;

public class Table {
	
	private Object id;
	
	private String classname;
	
	private String tablename;
	
	private List<Field> fields;
	
	private boolean hasFixedField=true;
	
	public Table() {
		super();
	}

	public Table(Object id) {
		super();
		this.id = id;
	}

	public static Table parse(Element e) throws NoSuchAttributeException{
		Table table = new Table();
		String classname=e.attribute("classname").getValue();
		if(classname==null) throw new NoSuchAttributeException();
		table.setClassname(classname);
		String tablename=e.attribute("tablename").getValue();
		if(tablename==null) throw new NoSuchAttributeException();
		table.setTablename(tablename);
		List<Element> elements = e.elements("table");
		if(elements==null)  {table.hasFixedField=false; return table;}
		for(Element element:elements){
			String name=element.attribute("name").getValue();
			if(name==null) throw new NoSuchAttributeException();
			String column=element.attribute("column").getValue();
			if(column==null) throw new NoSuchAttributeException();
			String type=element.attribute("type").getValue();
			if(type==null) throw new NoSuchAttributeException();
			try {
				Field field = Field.parse(name,column,type);
				table.fields.add(field);
			} catch (UnknowFidleException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return table;
	}


	public Object getId() {
		return id;
	}


	public void setId(Object id) {
		this.id = id;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}


	public String getTablename() {
		return tablename;
	}


	public void setTablename(String tablename) {
		this.tablename = tablename;
	}


	public List<Field> getFields() {
		return fields;
	}


	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	
	
	
	
	

}
