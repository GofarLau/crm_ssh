package com.gofar.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gofar.dao.BaseDao;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;//用于接受运行期泛型类型
	
	
	
	
	public BaseDaoImpl() {
	//获得当前对象的泛型父类对象 因为是在子类运行时候执行 所以所获得的class类型就是本身
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void saveOrUpdate(T t) {
		//getHibernateTemplate().save(t);
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}
	
	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);//先去对象
		getHibernateTemplate().delete(t);
		
	}
	
	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		return  (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalAcount(DetachedCriteria dc) {
		//设置查询的聚合函数  返回总记录数
		dc.setProjection(Projections.rowCount());
		
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		
		//清空之前的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
		
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start,
			Integer pageSize) {

		return (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
	}



}
