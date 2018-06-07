package com.yuanzijue.config;

import java.io.File;

import org.dom4j.Element;

public interface Config {
	
	// 获取配置文件根节点
	public Element getRoot();
	
	// 获取文件
	public File file();
	
	

}
