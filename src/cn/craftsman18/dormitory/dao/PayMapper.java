package cn.craftsman18.dormitory.dao;

import java.util.List;
import cn.craftsman18.dormitory.pojo.Cost;

public interface PayMapper {
	
	public List<Cost> queryList();
	public Integer queryListCount();

}
