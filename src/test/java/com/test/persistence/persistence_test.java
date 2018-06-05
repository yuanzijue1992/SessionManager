package com.test.persistence;

import org.junit.Test;

import com.yuanzijue.persistence.Field;
import com.yuanzijue.persistence.exception.UnknowFidleException;

public class persistence_test {
	@Test
	public void Field_parse_1(){
		String name="user_name";
		String column="name";
		String type="String";
		
		try {
			Field field = Field.parse(name,column,type);
			System.out.println(field);
			
		} catch (UnknowFidleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void Field_parse_2(){
		String name="user_name";
		String column="name";
		String type="unknow";
		
		try {
			Field field = Field.parse(name,column,type);
		} catch (UnknowFidleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
