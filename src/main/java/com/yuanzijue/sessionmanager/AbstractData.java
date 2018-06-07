package com.yuanzijue.sessionmanager;

import java.util.Iterator;
import java.util.Map;


import com.yuanzijue.persistence.Config;
import com.yuanzijue.session.PersistenceSession;

public abstract class AbstractData implements Data{
	
	protected Config config;
	
	
	AbstractData(Config config){
		this.config=config;
		init();
	}

	protected abstract void init();
	
	protected abstract void saveSession(String key,Object value);
	
	protected abstract void getSession(String id);
	
	

	@Override
	public void save(PersistenceSession session) {
		
		// 遍历session
		Map sessions = session.getAttributes();
		Iterator it = sessions.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			String classname = value.getClass().getName();
			// 如果此attribute中保存的value是需要保存的数据
			if(config.getMap().get(classname)!=null){
				//保存数据到数据库
				saveSession(key,value);
			}
			
		}
		
	}

	@Override
	public void get(String id) {
		getSession(id);
		
	}

	@Override
	public void update(PersistenceSession session) {
				
	}

}
