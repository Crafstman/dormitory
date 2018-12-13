package cn.craftsman18.dormitory.dao;

import cn.craftsman18.dormitory.pojo.User;

public interface LoginMapper {
	public User login(String name);
	
	public void register(User user);
}
