package com.yuanzijue.parseconfig;


import java.util.List;

import org.dom4j.Element;

import com.yuanzijue.persistence.exception.NoSuchAttributeException;
import com.yuanzijue.persistence.exception.NoSuchElementException;

public class Parse {
	
	public static Element parseElement(Element root,String name) throws NoSuchElementException {
		Element e = root.element(name);
		if(e==null) throw new NoSuchElementException(name);
		return e;
	}
	
	public static String parseAttribute(Element root,String name) throws NoSuchAttributeException {
		String s = root.attribute(name).getValue();
		if(s==null) throw new NoSuchAttributeException(name);
		return s;	
	}
	
	public static Field parseField(Element root){
		Field field = new Field();
		try {
			field.setKey(Parse.parseAttribute(root, "name"));
			field.setColumn(Parse.parseAttribute(root, "column"));			
		} catch (NoSuchAttributeException e) {
			e.printStackTrace();
		}
		
		try{
			String clazz = Parse.parseAttribute(root, "class");
			field.setIsTable(true);
			field.setClassname(clazz);
		}catch(NoSuchAttributeException e){
			
		}
		return field;
	}
	
	public static Table parseTable(Element root){
		Table table = new Table();
		try {
			String name = Parse.parseAttribute(root, "name");
			String tablename = Parse.parseAttribute(root, "table");
			
			table.setClassname(name);
			table.setTablename(tablename);
			List<Element> ps = root.elements("property");
			for(Element e:ps){
				table.getFields().add(Parse.parseField(e));
			}
		} catch (NoSuchAttributeException e) {
			e.printStackTrace();
		}
		return table;
			
	}
	
}
