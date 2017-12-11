package com.gofar.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gofar.domain.Customer;
import com.gofar.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	void add(Customer customer);

	Customer getById(long cust_id);

	void addOrUpdate(Customer customer);

}
