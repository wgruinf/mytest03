package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerMapper {
	/**
	 * 根据QueryVo查询客户的总条数
	 */
	int queryCustomerTotalByQueryVo(QueryVo queryVo);
	/**
	 * 根据QueryVo查询客户
	 */
	List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	/*
	 * 到修改页面
	 */
	Customer queryCustomerById(Integer id);
	/*
	 * 修改页面
	 */
	void update(Customer customer);
	void deleteCustomerById(Integer id);
}
