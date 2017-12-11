package com.gofar.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//增加或者修改
	 void saveOrUpdate(T t);
	//增加
	 void save(T t);
	//删除
	 void delete(T t);
	void delete(Serializable id);
	//修改
	 void update(T t);
	//查找
		//根据id查找
	 T getById(Serializable id);
		//符合条件的总记录数
	 Integer getTotalAcount(DetachedCriteria dc);
		//查询分页数据列表
	 List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
