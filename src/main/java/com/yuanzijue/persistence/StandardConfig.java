package com.yuanzijue.persistence;

import java.util.List;

import org.apache.catalina.Context;
import org.dom4j.Element;

import com.yuanzijue.persistence.exception.NoSuchAttributeException;
import com.yuanzijue.persistence.exception.NoTableException;

public class StandardConfig extends AbstractConfig{
	
	public StandardConfig(Context context) {
		super(context);
	}

	public String filepath(Context context){
		String docbase = context.getDocBase();
		docbase+="/WEB-INF/SessionManager.xml";
		docbase=docbase.replaceAll("/", "\\");
		return docbase;
	}
	
	protected void parseId(){
		Element e = root.element("id");
		if(e==null)
			try {
				throw new NoSuchAttributeException();
			} catch (NoSuchAttributeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		this.id = e.getText();
		
	}
	
	protected void parseTables(){
		Element tables_element = root.element("tables");
		if(tables_element==null)
			try {
				throw new NoTableException();
			} catch (NoTableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		List<Element> tables = tables_element.elements("table");
		if(tables==null)
			try {
				throw new NoTableException();
			} catch (NoTableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for(Element e:tables){
			try {
				Table table = Table.parse(e);
				table.setId(id);
				this.tables.add(table);
			} catch (NoSuchAttributeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	protected void register() {
		if(tables!=null){
			for(Table table:tables){
				tablemap.put(table.getClassname(), table.getTablename());
			}
		}		
	}
}
