/**
 * 
 */
package com.air.project.common.dict.cache;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.air.project.common.dict.SyncAble;
import com.air.project.common.dict.annotations.BeanAttr;
import com.air.project.common.dict.annotations.BeanType;
import com.air.project.common.dict.entity.Dict;
import com.air.project.utils.string.StringUtils;
import com.google.common.collect.Maps;

/**
 * @author air
 *
 * 2016年2月3日 下午2:41:54
 */
public class ConfigManager {
	
	private static HashMap<String, HashMap<Long,Dict>> map = Maps.newHashMap();
	
	private static SyncAble syncAble;
	
	private static boolean hasSync(){
		return syncAble!=null;
	}
	
	public static void init(SyncAble syncAble){
		ConfigManager.syncAble=syncAble;
		if(hasSync()){
			List<Dict> list=syncAble.getList();
			for(Dict d:list){
				trans(d);
			}
		}
		
	}
	
	
	/**
	 * 获取中文名
	 * @param cls
	 * @param attrId
	 * @return
	 */
	public static <T extends Dict> String getCnName(Class<T> cls, long attrId) {
		Dict d = getDict(cls, attrId);
		if (d != null) {
			return d.getCnName();
		}
		return null;
	}

	public static <T extends Dict> String getValue(Class<T> cls, long attrId) {
		Dict d = getDict(cls, attrId);
		if (d != null) {
			return d.getValue();
		}
		return null;
	}

	public static <T extends Dict> String getEnName(Class<T> cls, long attrId) {
		Dict d = getDict(cls, attrId);
		if (d != null) {
			 return d.getEnName();
		}
		return null;
	}

	/**
	 * 获取类型
	 * @param cls
	 * @return
	 */
	public static <T extends Dict> Collection<Dict> getList(Class<T> cls) {
		String type = getType(cls);
		check(type, cls, 0);
		if (map.containsKey(type)) {
			HashMap<Long, Dict> tmp = map.get(type);
			return tmp.values();
		}
		return null;
	}
	/**
	 * 获取数据字典
	 * @param cls
	 * @param attrId
	 * @return
	 */
	public static <T extends Dict> Dict getDict(Class<T> cls, long attrId) {
		String type = getType(cls);
		check(type, cls, attrId);
		if (map.containsKey(type)) {
			HashMap<Long, Dict> tmp = map.get(type);
			return tmp.get(attrId);
		}
		return null;
	}
	
	
	
	/***********以下为私有方法***************/
	
	private static void trans(Dict d) {
		String type = d.getType();
		if (!StringUtils.isEmpty(type)) {
			HashMap<Long, Dict> tmp = map.get(type);
			if (tmp == null || tmp.isEmpty()) {
				map.put(type, new HashMap<Long, Dict>());
			}
			long atrr = d.getAttr();
			if (atrr!=0) {
				map.get(type).put(d.getAttr(), d);
			}
		}
	}
	private static <T extends Dict> String getType(Class<T> cls) {
		if (cls.isAnnotationPresent(BeanType.class)) {
			BeanType beanType = (BeanType) cls.getAnnotation(BeanType.class);
			String type = beanType.value();
			return type;
		}
		return null;
	}
	private static <T extends Dict> String getLable(Class<T> cls) {
		if (cls.isAnnotationPresent(BeanType.class)) {
			BeanType beanType = (BeanType) cls.getAnnotation(BeanType.class);
			String lable = beanType.lable();
			return lable;
		}
		return null;
	}
	private static <T extends Dict> void check(String type, Class<T> cls, long attrId) {
		if (map.containsKey(type)) {
			if (map.get(type).containsKey(attrId)) {
				return;
			}
		}else{
			map.put(type, new HashMap<Long, Dict>());
		}
		HashMap<Long, Dict> tmp = map.get(type);
		String lable = getLable(cls);
		Field[] at = cls.getDeclaredFields();
		for (Field f : at) {
			f.setAccessible(true);
			if (f.isAnnotationPresent(BeanAttr.class)) {
				try {
					long attr = f.getLong(cls);
					if (!tmp.containsKey(attr)) {
						BeanAttr ba = (BeanAttr) f.getAnnotation(BeanAttr.class);
						Dict d = new Dict();
						d.setAttr(attr);
						d.setType(type);
						d.setLable(lable);
						d.setValue(ba.value());
						d.setSortBy(ba.sortBy());
						d.setEnName(ba.enName());
						d.setCnName(ba.cnName());
						d.setRefAttr(ba.refAttr());
						d.setSystemType(ba.systemType());
						map.get(type).put(attr, d);
						// insert to DB
						if(hasSync()){
							syncAble.save(d);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
