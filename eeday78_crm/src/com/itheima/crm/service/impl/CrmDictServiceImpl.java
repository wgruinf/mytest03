package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.CrmDictService;
@Service
public class CrmDictServiceImpl implements CrmDictService{
	@Autowired
	private BaseDictMapper baseDictMapper;
	/*
	 * 条件查询客户
	 */
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		List<BaseDict> queryBaseDictByDictTypeCode = baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
		return queryBaseDictByDictTypeCode;
	}
}
