package com.yuanzjue.store;

import org.apache.catalina.Session;

import com.yuanzijue.session.PersistenceSession;

public interface Store {
	
	// 保存session
	public void save(PersistenceSession ps);
	
	// 恢复session
	public Session get(String id);
	
	// 更新session
	public void update();
	
	

}
