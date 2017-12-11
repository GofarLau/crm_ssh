package com.gofar.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gofar.domain.LinkMan;
import com.gofar.utils.PageBean;

public interface LinkManService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	void save(LinkMan linkman);

	LinkMan getById(Long lkm_id);

}
