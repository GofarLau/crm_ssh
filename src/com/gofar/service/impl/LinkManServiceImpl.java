package com.gofar.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gofar.dao.LinkManDao;
import com.gofar.domain.LinkMan;
import com.gofar.service.LinkManService;
import com.gofar.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {
	
	private LinkManDao lmd;
	
	
	
	public void setLkd(LinkManDao lmd) {
		this.lmd = lmd;
	}



	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		
		//获得总记录数
		Integer totalCount = lmd.getTotalAcount(dc);
		
		//创建pagebean对象
		PageBean pb = new PageBean(currentPage,totalCount,pageSize);
		
		//使用dao返回pagebean list数据
		List<LinkMan> pageList = lmd.getPageList(dc, pb.getStart(), pb.getPageSize());
		
		//pagebean获得list数据
		pb.setList(pageList);
		return pb;
	}



	@Override
	public void save(LinkMan linkman) {
		lmd.save(linkman);
	}



	@Override
	public LinkMan getById(Long lkm_id) {
		return 	lmd.getById(lkm_id);
	}

}
