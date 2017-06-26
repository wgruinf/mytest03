package com.itheima.crm.service;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {
	 Page<Customer> queryCustomerByPage(QueryVo queryVo);

	Customer queryCustomerById(Integer id);
	void update(Customer customer);


	void deleteCustomerById(Integer id);
}
