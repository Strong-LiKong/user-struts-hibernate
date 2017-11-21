package com.qingshixun.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.qingshixun.model.User;
import com.qingshixun.service.UserService;

@Controller("userAction")
@Namespace("/")
@ParentPackage("baseStruts")
@Scope("prototype")
public class UserAction {
	
	private User user;
	
	private String message;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 新增用户
	 * @return
	 */
	@Action(value="addUser",results={@Result(name="success",type="json")})
	public String addUser(){
		user.setCreateDate(new Date());
		user.setUpdateDate(user.getCreateDate());
		message=userService.addUser(user);
		return "success";
	}
	
	/**
	 * 删除
	 * @return
	 */
	@Action(value="deleteUser",results={@Result(name="success",type="json")})
	public String deleteUser(){
		message=userService.deleteUser(user.getId());
		return "success";
	}
	
	/**
	 * 更新用户信息
	 * @return
	 */
	@Action(value="upadtaUser",results={@Result(name="success",type="json")})
	public String updataUser(){
		user.setUpdateDate(new Date());
		message=userService.updataUser(user);
		return "success";
	}
	
	/**
	 * 加载编辑用户信息页面数据
	 * @return
	 */
	@Action(value="uploadEditUserPage",results={@Result(name="success",location="/WEB-INF/view/editUserFrom.jsp")})
	public String uploadEditUserPage(){
		user=userService.getUserById(user.getId());
		return "success";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
