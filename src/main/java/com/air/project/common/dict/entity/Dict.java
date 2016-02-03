/**
 * 
 */
package com.air.project.common.dict.entity;


import lombok.Data;

/**
 * @author air
 *
 * 2016年2月3日 下午1:40:59
 */
@Data
public class Dict {
	
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
