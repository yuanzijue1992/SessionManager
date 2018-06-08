package com.yuanzjue.store;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.catalina.Session;
import org.hamcrest.core.IsInstanceOf;

import com.yuanzijue.config.Config;
import com.yuanzijue.parseconfig.Mapper;
import com.yuanzijue.session.PersistenceSession;



public abstract class AbstractStore implements Store{
	
	protected Config config;
	
	protected Mapper mapper;
	
	public AbstractStore(Config config) {
		this.config=config;
		init();
	}
	
	protected abstract void init();
	
	protected abstract void saveMapper(PersistenceSession ps,Mapper map);
	
	protected abstract void saveMap(Map map,String tablename);
	
	protected abstract Session getSession();
	
	protected abstract void updeSession();

	@Override
	public void save(PersistenceSession ps) {

		saveMapper(ps,mapper);
	}

	@Override
	public Session get(String id) {
		return getSession();
	}

	@Override
	public void update() {
		updeSession();
		
	}

}
