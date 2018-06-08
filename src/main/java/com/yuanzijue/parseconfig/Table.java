package com.yuanzijue.parseconfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.yuanzijue.persistence.exception.NoSuchAttributeException;
import com.yuanzijue.persistence.exception.UnknowFidleException;

public class Table implements Mapper{
	
	// 这个表的id
	private String id;
	
	// 这个表的classname
	private String classname;
	
	// 这个表的tablename
	private String tablename;
	
	// 这张表的字段
	private List<Field> fields;
	
	// 这个表是不是session表
	private boolean isSession;
	
	private boolean hasFixedField=true;
	
	public Table() {
		super();
	}

	public Table(String id) {
		super();
		this.id = id;
	}

//	public static Table parse(Element e) throws NoSuchAttributeException{
//		Table table = new Table();
//		String classname=e.attribute("classname").getValue();
//		if(classname==null) throw new NoSuchAttributeException("classname");
//		table.setClassname(classname);
//		String tablename=e.attribute("tablename").getValue();
//		if(tablename==null) throw new NoSuchAttributeException("tablename");
//		table.setTablename(tablename);
//		List<Element> elements = e.elements("table");
//		if(elements==null)  {table.hasFixedField=false; return table;}
//		for(Element element:elements){
//			String name=element.attribute("name").getValue();
//			if(name==null) throw new NoSuchAttributeException("name");
//			String column=element.attribute("column").getValue();
//			if(column==null) throw new NoSuchAttributeException("column");
//			try {
//				Field field = Field.parse(name,column);
//				table.fields.add(field);
//			} catch (UnknowFidleException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//		return table;
//	}


	


	public void setId(String id) {
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

	public boolean isSession() {
		return isSession;
	}

	public void setSession(boolean isSession) {
		this.isSession = isSession;
	}

	public boolean isHasFixedField() {
		return hasFixedField;
	}

	public void setHasFixedField(boolean hasFixedField) {
		this.hasFixedField = hasFixedField;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getTableName() {
		return tablename;
	}

	@Override
	public String getClassName() {
		return classname;
	}

	@Override
	public Map<String, Object> getProps() {
		Map<String,Object> map = new HashMap<String,Object>();
		for(Field f:fields){
			if(f.getIsTable()){
				map.put(f.getKey(), f.getTable());
			}else{
				map.put(f.getKey(), f.getColumn());
			}			
		}
		return map;
	}
	
}
