package com.yuanzijue.parseconfig;


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
}
