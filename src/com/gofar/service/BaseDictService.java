package com.gofar.service;

import java.util.List;

import com.gofar.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);
	
}
