package com.qingshixun.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * page 实体类
 * @author back
 */

@Component
@Scope("prototype")
public class Page {
	
	private int totalUser;//用户总数
	
	private int totalPage;//总页面数
	
	private int numberOfPage;//每页显示用户的数量
	
	private int pageNumber;//当前页数
	
	private List<User> userList;//该页用户数据列表

	public int getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "Page [totalUser=" + totalUser + ", totalPage=" + totalPage + ", numberOfPage=" + numberOfPage
				+ ", pageNumber=" + pageNumber + ", userList=" + userList + "]";
	}
}
