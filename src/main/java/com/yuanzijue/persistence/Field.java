package com.yuanzijue.persistence;

import java.sql.Date;

import com.yuanzijue.persistence.exception.UnknowFidleException;




public class Field {
	
	public static int INT=1;
	
	public static int STRING=2;
	
	public static int LONG=3;
	
	public static int BOOLEAN=4;
	
	public static int DATE = 5;
	
	public static int FLOAT = 6;
	
	private String name;
	
	private String column;
	
	private int type;
	
	
	public Field() {
		super();
	}

	
	public static Field parse(String name,String column,String type) throws UnknowFidleException{
		Field field = new Field();
		field.setName(name);
		field.setColumn(column);
		switch(type){
		case "String": field.setType(Field.STRING);  break;
		case "int": field.setType(Field.INT);  break;
		case "long": field.setType(Field.LONG);  break;
		case "bool": field.setType(Field.BOOLEAN);  break;
		case "date": field.setType(Field.DATE); break;
		case "float": field.setType(FLOAT); break;
		default : throw new UnknowFidleException();
		}
		return field;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

	public String getColumn() {
		return column;
	}


	public void setColumn(String column) {
		this.column = column;
	}


	@Override
	public String toString(){
		String s= "name:"+name+";"+"type:";
		switch(type){
		case 1 : s+="int"; break;
		case 2 : s+="string";break;
		case 3 : s+="long";break;
		case 4 : s+="bool";break;
		case 5 : s+="date";break;
		case 6 : s+="float";break;
		default : try {
				throw new UnknowFidleException();
			} catch (UnknowFidleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return s;
	}
	
	
	
	
	
}
