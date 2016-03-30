/**
 * 
 */
package com.air.project.common.dict.entity;


import java.io.Serializable;

import com.air.project.common.dict.IDict;

import lombok.Data;

/**
 * @author air
 *
 * 2016年2月3日 下午1:40:59
 */
@Data
public class Dict implements IDict,Serializable,Cloneable{
	
	private static final long serialVersionUID = -7314025820623506939L;
	public long id;
	/**
	 * @see com.air.project.common.dict.entity.DelFlag
	 */
	public long delFlag=DelFlag.NOT_DELETE;
	
	/** 数据字典类型 唯一
	 * @see com.air.project.common.dict.annotations.BeanType
	 */
	public String type;
	/**
	 * 类型中文
	 */
	public String lable;
	
	/** 属性值
	 * @see com.air.project.common.dict.annotations.BeanAttr
	 */
	public long attr;
	public String value;
	public long sortBy;
	public long refAttr;
	public long systemType;
	public String cnName;
	public String enName;
	public String remark;
}
