package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;
	public Page<Customer> queryCustomerByPage(QueryVo queryVo){
		//创建Page对象
		Page<Customer> page = new Page<Customer>();
		//当前页
		if(null==queryVo.getPage()){
			queryVo.setPage(1);
		}
		page.setPage(queryVo.getPage());
		//显示条数
		page.setSize(5);
		queryVo.setRows(5);
		//开始行
		int setStart = (queryVo.getPage()-1)*queryVo.getRows();
		queryVo.setStart(setStart);
		//查询总条数
		int queryCustomerTotalByQueryVo = customerMapper.queryCustomerTotalByQueryVo(queryVo);
		//分页查询
		List<Customer> queryCustomerByQueryVo = customerMapper.queryCustomerByQueryVo(queryVo);
		
		// 总条数
		page.setTotal(queryCustomerTotalByQueryVo);
		// 结果 集
		page.setRows(queryCustomerByQueryVo);
		return page;
	}
	public Customer queryCustomerById(Integer id) {
		return customerMapper.queryCustomerById(id);
	}
	@Override
	public void update(Customer customer) {
		customerMapper.update(customer);
	}
	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}
}
