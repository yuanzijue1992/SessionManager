package com.yuanzijue.session;

import java.util.Map;

import org.apache.catalina.Manager;
import org.apache.catalina.session.StandardSession;

public class PersistenceSession extends StandardSession{

	public PersistenceSession(Manager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	
	public Map getAttributes(){
		return attributes;
	}

}
