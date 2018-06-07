package com.yuanzijue.config;

import java.io.File;

import org.apache.catalina.Context;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class StandardConfig extends AbstractConfig{

	public StandardConfig(Context context) {
		super(context);	
	}

	@Override
	protected void init() {
		String docbase = context.getDocBase();
		docbase+="/WEB-INF/SessionManager.xml";
		docbase=docbase.replaceAll("/", "\\");
		file = new File(docbase);
		SAXReader saxReader = new SAXReader();
        Document document=null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取根节点
        root = document.getRootElement();
	}

}
