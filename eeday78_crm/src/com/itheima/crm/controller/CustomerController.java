package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.CrmDictService;
import com.itheima.crm.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CrmDictService crmDictService;
	@Autowired
	private CustomerService customerService;
	//客户来源
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	//客户行业
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	//客户级别
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	/*
	 * 显示用户列表
	 */
	@RequestMapping("list")
	public String queryCustomerList(QueryVo queryVo ,Model model){
		/*
		 * 客户来源
		 */
		List<BaseDict> customerFrom = crmDictService.queryBaseDictByDictTypeCode(this.CUSTOMER_FROM_TYPE);
		/*
		 *  所属行业
		 */
		List<BaseDict> industryType =  crmDictService.queryBaseDictByDictTypeCode(this.CUSTOMER_INDUSTRY_TYPE);
		/*
		 * 客户级别
		 */
		List<BaseDict> levelType  = crmDictService.queryBaseDictByDictTypeCode(this.CUSTOMER_LEVEL_TYPE);
		/*
		 *分页查询到数据
		 */
		Page<Customer> page = customerService.queryCustomerByPage(queryVo);		
		model.addAttribute("page",page);
		model.addAttribute("customerFrom", customerFrom);
		model.addAttribute("industryType", industryType);	
		model.addAttribute("levelType", levelType );
		return "customer";
	}
	//点击修改按钮 弹出层
		@RequestMapping(value = "edit.action")
		public @ResponseBody
		Customer edit(Integer id){
			Customer queryCustomerById = customerService.queryCustomerById(id);//Shift +Ctrl + i
			return queryCustomerById;
		}
		//修改页面
	@RequestMapping("/update.action")
	public @ResponseBody
	String update(Customer customer){
		customerService.update(customer);
		return "OK";
	}
	//删除页面
	@RequestMapping(value = "/delete.action")
	public @ResponseBody
	String delete(Integer id){
		//删除
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
