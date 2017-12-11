package com.gofar.web.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.logging.log4j.core.layout.JsonLayout;
import org.apache.struts2.ServletActionContext;

import com.gofar.domain.BaseDict;
import com.gofar.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

public class BaseDictAction extends ActionSupport {
	
	private String dict_type_code;
	
	private BaseDictService bds;

	@Override
	public String execute() throws Exception {
		
		//调用services 返回baseDict对象集合
		List<BaseDict> list = bds.getListByTypeCode(dict_type_code);
		
		//使用jsonlib 将对象转换成数组 再转换成字符串
		String json = JSONArray.fromObject(list).toString();
		
		//将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
	}

	public BaseDictService getBds() {
		return bds;
	}

	public void setBds(BaseDictService bds) {
		this.bds = bds;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	
	
	
	
}
