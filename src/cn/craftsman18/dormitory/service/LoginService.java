package cn.craftsman18.dormitory.service;

import cn.craftsman18.dormitory.pojo.User;

public interface LoginService {
	public User login(String name);
	public void register(User user);

}
