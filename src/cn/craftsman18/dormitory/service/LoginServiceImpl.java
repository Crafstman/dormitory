package cn.craftsman18.dormitory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.craftsman18.dormitory.dao.LoginMapper;
import cn.craftsman18.dormitory.pojo.User;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public User login(String name) {
		User user = loginMapper.login(name);
		return user;
	}

	@Override
	public void register(User user) {
		loginMapper.register(user);

	}

}
