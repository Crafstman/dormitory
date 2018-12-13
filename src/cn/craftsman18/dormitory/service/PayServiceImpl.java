package cn.craftsman18.dormitory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.craftsman18.dormitory.dao.PayMapper;
import cn.craftsman18.dormitory.pojo.Cost;

@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayMapper payMapper;
	
	@Override
	public List<Cost> queryList() {
		List<Cost> billList = payMapper.queryList();
		
		return billList;
	}

	@Override
	public Integer queryListCount() {
		int Count = payMapper.queryListCount();
		return Count;
	}

}
