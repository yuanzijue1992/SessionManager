package com.yuanzijue.config;

import java.io.File;

import org.apache.catalina.Context;
import org.dom4j.Element;

public abstract class AbstractConfig implements Config{
	
	protected Context context;
	
	protected File file;
	
	protected Element root;
	
	
	public AbstractConfig(Context context) {
		this.context=context;
		init();
	}
	
	protected abstract void init();

	@Override
	public Element getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public File file() {
		// TODO Auto-generated method stub
		return file;
	}

}
