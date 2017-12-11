package com.gofar.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gofar.dao.CustomerDao;
import com.gofar.domain.Customer;
import com.gofar.service.CustomerService;
import com.gofar.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao cd;

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		//调用dao查询总记录数
		Integer totalCount = cd.getTotalAcount(dc);
		
		//创建pageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//调用dao对象 获得分页数据list
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//将分页数据放入pageBean中
		pb.setList(list);
		//返回pagebean
		return pb;
	}

	@Override
	public void add(Customer customer) {
		 cd.save(customer);
	}

	@Override
	public Customer getById(long cust_id) {
		Customer customer = cd.getById(cust_id);
		return customer;
	}

	@Override
	public void addOrUpdate(Customer customer) {
		cd.saveOrUpdate(customer);
	}

}
