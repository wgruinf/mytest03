package com.itheima.crm.service;

import java.util.List;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.QueryVo;

public interface CrmDictService{
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
	
}
