package cn.craftsman18.dormitory.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.craftsman18.dormitory.pojo.Cost;
import cn.craftsman18.dormitory.service.PayService;

@Controller
public class PayController {
	@Autowired
	private PayService payService;

	/**
	 * 查询社费详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query")
	public ModelAndView query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 查询列表
		List<Cost> payList = payService.queryList();
		ArrayList<Cost> list = new ArrayList<Cost>();
		for (Cost cost : payList) {
			list.add(cost);
		}
		int Count = payService.queryListCount();
		System.out.println("查询到" + Count + "条数据");
		System.out.println(list);
		System.out.println(list);

		// 定义返回路径
		ModelAndView mad = new ModelAndView("query");
		// 将数据存入modelMap
		mad.addObject("message", list);
		return mad;
	}

	@ResponseBody
	@RequestMapping("/queryCount")
	public int queryListCount() throws Exception{
		Integer queryListCount = payService.queryListCount();
		return queryListCount;
	}

	@RequestMapping("pay")
	public void pay(Cost cost, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(cost);
		Date time  = new Date();
		cost.time = time;
		
	}
}
