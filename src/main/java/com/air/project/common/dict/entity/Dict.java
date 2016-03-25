/**
 * 
 */
package com.air.project.common.dict.entity;


import com.air.project.common.dict.IDict;

import lombok.Data;

/**
 * @author air
 *
 * 2016年2月3日 下午1:40:59
 */
@Data
public class Dict implements IDict{
	
	private static final long serialVersionUID = -7314025820623506939L;
	public long id;
	/**
	 * @see com.air.project.common.dict.entity.DelFlag
	 */
	public long delFlag=DelFlag.NOT_DELETE;
	
	/**
	 * @see com.air.project.common.dict.annotations.BeanType
	 */
	public String type;
	public String lable;
	
	/**
	 * @see com.air.project.common.dict.annotations.BeanAttr
	 */
	public long attr;
	public String value;
	public long sortBy;
	public long refAttr;
	public long systemType;
	public String cnName;
	public String enName;
}
