package cn.craftsman18.dormitory.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.craftsman18.dormitory.pojo.User;
import cn.craftsman18.dormitory.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@ResponseBody
	@RequestMapping("/register")
	public boolean register(HttpServletRequest request, HttpServletResponse response, String name, String passwd)
			throws Exception {
		// 初始化变量
		boolean result = false; // 注册结果
		// 密码确认
		System.out.println(name);
		System.out.println(passwd);

		// 判断用户名是否存在
		User sqlUser = loginService.login(name);
		System.out.println(sqlUser);
		if (sqlUser != null) {
			result = false;
			System.out.println("注册失败：用户名"+name+"已存在");
		} else {
			// 封装
			User user = new User();
			user.setName(name);
			user.setPasswd(passwd);
			// 向数据库注册
			System.out.println(user.getName()+"注册成功");
			loginService.register(user);
			result = true;
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public boolean login(HttpServletRequest request, HttpServletResponse response, String name, String passwd) {
		User user = loginService.login(name);
		if(user ==null) {
			System.out.println("用户未注册");
			return false;
		}
		String sqlPasswd = user.getPasswd();
		//System.out.println(sqlPasswd);
		//明文密码确认
		System.out.println("用户"+name+"使用"+passwd+"尝试登陆");
	
		if(sqlPasswd.equals(passwd))
			System.out.println("用户"+name+"登陆成功");
		else 
			System.out.println("用户"+name+"登陆失败");
		return sqlPasswd.equals(passwd);
	}

}
