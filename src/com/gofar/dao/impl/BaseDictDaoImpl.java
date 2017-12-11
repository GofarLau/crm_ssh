package com.gofar.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gofar.dao.BaseDictDao;
import com.gofar.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//criteria
		//创建离线criteria
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//添加查询条件
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//findByCriteria
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
