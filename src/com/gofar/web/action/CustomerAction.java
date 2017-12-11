package com.gofar.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gofar.domain.Customer;
import com.gofar.service.CustomerService;
import com.gofar.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	private CustomerService cs;
	
	private Integer currentPage;
	private Integer pageSize;
	
	private File photo;
	private String photoFileName;
	private String photoContentType;
	


	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String list() throws Exception{
		
		//使用离线criteria进行查询
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())){
			//如果获得customer对象不为空 ,则进行模糊查询
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		//调用services的方法 进行查询 返回一个pagebean 分页数据
		PageBean pb = cs.getPageBean(dc,currentPage,pageSize);
		//将分页数据放入到request域中,转发到列表页
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}	
	
	public String add() throws Exception{
	//	文件上传
		if (photo!=null ) {
			System.out.println(photoContentType);
			
			photo.renameTo(new File("E:/tool/"+photoFileName));
		}
		
	//------------------------------
		 cs.addOrUpdate(customer);
		 return "toList";
	}
		
	public String toedit(){
		//调用service 根据id获得对象
		Customer c = cs.getById(customer.getCust_id());
		//将客户对象放置到request域中 转发到编辑页面 进行回显
		ActionContext.getContext().put("customer", c);
		//转发到edit页面
		return "edit";
	}
		
		
	//模型驱动的方法 将对象置于栈顶
	@Override
	public Customer getModel() {
		
		return customer;
	}


	//getter setter
	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public CustomerService getCs() {
		return cs;
	}



	public void setCs(CustomerService cs) {
		this.cs = cs;
	}



	public Integer getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
