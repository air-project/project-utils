/**
 * 
 */
package com.air.project.common.dict;

import java.util.List;

import com.air.project.common.dict.entity.Dict;

/**
 * @author air
 *
 * 2016年2月3日 下午2:57:02
 */
public interface SyncAble {
	public List<Dict> getList();
	
	public void save(Dict dict);
}
