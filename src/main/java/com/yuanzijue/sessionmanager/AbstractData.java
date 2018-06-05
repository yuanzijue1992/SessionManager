package com.yuanzijue.sessionmanager;

import com.yuanzijue.persistence.Config;

public abstract class AbstractData implements Data{
	
	protected Config config;
	
	
	AbstractData(Config config){
		this.config=config;
		init();
	}

	protected abstract void init();
	
	protected abstract void saveSession();
	
	protected abstract void getSession();

	@Override
	public void save() {
		
		saveSession();
		
	}

	@Override
	public void get() {
		getSession();
		
	}

	@Override
	public void update() {
				
	}

}
