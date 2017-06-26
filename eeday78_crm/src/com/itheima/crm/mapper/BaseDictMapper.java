package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictMapper {
	/**
	 * 客户类别查询
	 */
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
	
}	
