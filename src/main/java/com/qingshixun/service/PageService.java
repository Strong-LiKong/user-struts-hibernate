package com.qingshixun.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingshixun.dao.UserDao;
import com.qingshixun.model.ChartData;
import com.qingshixun.model.Page;

@Service
@Transactional //spring事务注解
public class PageService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 获取用户管理页面的数据
	 * @param page
	 * @return
	 */
	public void getPageDataByPage(Page page,String nameString){
		if(page.getPageNumber()== 0){
			page.setPageNumber(1);
		}
		System.out.println("页面请求："+page.getPageNumber());
		page.setNumberOfPage(10);
		try {
			//获取所有的记录数
			page.setTotalUser(userDao.getTotalNumberOfUser(nameString));
			//计算总的页数
			int totalPage=page.getTotalUser()/page.getNumberOfPage();
			page.setTotalPage(page.getTotalUser()%page.getNumberOfPage()==0?totalPage:totalPage+1);
			//无效的页码,将页码设置为最后一页
			if(page.getPageNumber() * page.getNumberOfPage() > page.getTotalUser()){
				page.setPageNumber(page.getTotalPage());
			}
			page.setUserList(userDao.getUserListByPage(page.getPageNumber(), page.getNumberOfPage(),nameString));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取用户分析扇形图数据
	 * @return
	 */
	public ChartData getPieData(){
		ChartData chartData=new ChartData();
		chartData.setLabels("男,女");
		int male=userDao.getNumberOfMale();
		chartData.setDatas(male+","+(userDao.getTotalNumberOfUser(null)-male));
		return chartData;
	}
	
	/**
	 * 获取用户分析线性图数据
	 * @return
	 */
	public ChartData getLineData(){
		ChartData chartData=new ChartData();
		List list=userDao.getlineData();
		Iterator  it=list.iterator();
		while(it.hasNext()){
			 Object[] res=(Object[]) it.next();
			 chartData.setDatas(chartData.getDatas()+res[1].toString()+",");
			 chartData.setLabels(chartData.getLabels()+res[0].toString()+",");
		}
		chartData.setDatas(chartData.getDatas().substring(0, chartData.getDatas().length()-1));
		chartData.setLabels(chartData.getLabels().substring(0, chartData.getLabels().length()-1));
		System.out.println(chartData);
		return chartData;
	}
}
