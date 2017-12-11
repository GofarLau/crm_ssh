package com.gofar.service.impl;

import java.util.List;

import com.gofar.dao.BaseDictDao;
import com.gofar.domain.BaseDict;
import com.gofar.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDao bdd;
	 
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		
		return bdd.getListByTypeCode(dict_type_code);
		
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
	
	
}
