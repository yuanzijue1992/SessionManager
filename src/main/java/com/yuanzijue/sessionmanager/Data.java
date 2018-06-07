package com.yuanzijue.sessionmanager;

import org.apache.catalina.Session;

import com.yuanzijue.session.PersistenceSession;

public interface Data {
	
	
	public void save(PersistenceSession session);
	
	public void get(String id);
	
	public void update(PersistenceSession session);

}
