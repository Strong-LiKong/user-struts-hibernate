package com.qingshixun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingshixun.dao.UserDao;
import com.qingshixun.model.User;

@Service("userService")
@Transactional //spring事务注解
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	/**
	 * 新增用户
	 * @param user
	 * @return 
	 */
	public String addUser(User user){
		String	message="";
		try{
			userdao.saveorUpdataUser(user);
			message="新增用户成功！";
		}catch(Exception e){
			message=e.getMessage();
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public String deleteUser(Long userId){
		String	message="";
		try {
			userdao.deleteUser(userId);
			message="删除成功！";
		} catch (Exception e) {
			message=e.getMessage();
			e.printStackTrace();
		}
		return message;
	}
	
	public String updataUser(User user){
		String	message="";
		try {
			userdao.saveorUpdataUser(user);
			message="修改成功！";
		} catch (Exception e) {
			message=e.getMessage();
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * 获取User
	 * @param userId
	 * @return
	 */
	public User getUserById(Long userId){
		try {
			 return userdao.getUserById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
