package cn.craftsman18.dormitory.service;

import java.util.List;
import cn.craftsman18.dormitory.pojo.Cost;

public interface PayService {
	public List<Cost> queryList();
	public Integer queryListCount();
}
