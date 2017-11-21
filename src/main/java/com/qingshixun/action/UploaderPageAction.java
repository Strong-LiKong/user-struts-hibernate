package com.qingshixun.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.qingshixun.model.ChartData;
import com.qingshixun.model.Page;
import com.qingshixun.service.PageService;

@Controller("uploaderPageAction") // spring注解，声明这是一个controller的action
// struts注解
@Namespace("/")
@ParentPackage("struts-default")
@Scope("prototype")
public class UploaderPageAction {

	private Page page;// 用户管理页面数据
	
	private static String nameString;//查询参数

	private ChartData pieChartData;// 用户分析页面扇形图数据
	
	private ChartData lineChartData;// 用户分析页面线性图数据	

	@Autowired
	private PageService pageService;

	/**
	 * 加载新增用户页面
	 * 
	 * @return
	 */
	@Action(value = "loadUserFormPage", results = {
			@Result(name = "success", location = "/WEB-INF/view/userFrom.jsp") })
	public String uploadUserFormPage() {
		return "success";
	}

	/**
	 * 加载用户管理页面
	 * 
	 * @return
	 */
	@Action(value = "loadUserListPage", results = {
			@Result(name = "success", location = "/WEB-INF/view/userList.jsp") })
	public String uploadUserListPage() {
		pageService.getPageDataByPage(page,nameString);
		System.out.println(nameString);
		return "success";
	}

	/**
	 * 加载用户分析页面
	 * 
	 * @return
	 */
	@Action(value = "loadUserAnalysisPage", results = {
			@Result(name = "success", location = "/WEB-INF/view/userAnalysis.jsp") })
	public String uploadUserAnalysisPage() {
		pieChartData=pageService.getPieData();
		lineChartData=pageService.getLineData();
		return "success";
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public ChartData getPieChartData() {
		return pieChartData;
	}

	public void setPieChartData(ChartData pieChartData) {
		this.pieChartData = pieChartData;
	}

	public ChartData getLineChartData() {
		return lineChartData;
	}

	public void setLineChartData(ChartData lineChartData) {
		this.lineChartData = lineChartData;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
}
