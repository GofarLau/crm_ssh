package com.gofar.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gofar.dao.CustomerDao;
import com.gofar.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	
	
	
	
	/*@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		
		List<Customer> list = (List<Customer>) super.getHibernateTemplate().findByCriteria(dc);
		return list.size();

	}

	@Override
	public List<Customer> getList(DetachedCriteria dc, int start,
			Integer pageSize) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	@Override
	public int add(final Customer customer) {
		getHibernateTemplate().execute(new HibernateCallback<Customer>() {

			@Override
			public Customer doInHibernate(Session session)
					throws HibernateException {
				session.save(customer);
				return null;
			}
			
		});
		return 1;
		
	}*/

}
