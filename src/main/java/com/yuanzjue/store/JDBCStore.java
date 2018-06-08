package com.yuanzjue.store;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.catalina.Session;

import com.yuanzijue.config.Config;
import com.yuanzijue.parseconfig.DataSource;
import com.yuanzijue.parseconfig.Mapper;
import com.yuanzijue.parseconfig.Parse;
import com.yuanzijue.session.PersistenceSession;

public class JDBCStore extends AbstractStore{
	
	private DataSource ds;

	public JDBCStore(Config config) {
		super(config);
		
	}

	@Override
	protected void init() {
		mapper = Parse.parseTable(config.getRoot());
		ds = new DataSource(config.getRoot());
	}

	@Override
	protected void saveMapper(PersistenceSession ps, Mapper map) {
		// session中的键值对
		Map as = ps.getAttributes();
		Iterator it = as.entrySet().iterator();
		// 用来保存需要保存的数据
		Map<String,Object> savemap = new HashMap<String,Object>();
		// 遍历session中的数据
		while(it.hasNext()){
			// 实际的键值对
			Entry entry = (Entry)it.next();
			// session中的key
			String key = (String) entry.getKey();
			// mapper中的相应value
			Object value = mapper.getProps().get(key);
			// 如果次key需要被保存
			if(value!=null){
				// 如果数map类型
				if(value instanceof Mapper){
					saveTable((Mapper)value,entry.getValue());
				}else{//如果数基础类型，将它放到savemap中
					savemap.put((String)value,entry.getValue());
				}
			}
			saveMap(savemap,mapper.getTableName());
		}
		
	}
	
	private void saveTable(Mapper mapper,Object value){
		String clazz = mapper.getClassName();
		
	}

	@Override
	protected void saveMap(Map map, String tablename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updeSession() {
		// TODO Auto-generated method stub
		
	}

}
