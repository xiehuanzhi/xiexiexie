package com.xiexie.service;

import com.xiexie.bean.GoodsInfo;
import com.xiexie.bean.GoodsInfoExample;
import com.xiexie.dao.GoodsInfoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsInfoService")
public class GoodsInfoServiceImpl implements GoodsInfoService{
	@Autowired(required = false)
	private GoodsInfoDAO goodsInfoDAO;
	public long countByExample(GoodsInfoExample example){
    	return goodsInfoDAO.countByExample(example);
    }

	public int deleteByExample(GoodsInfoExample example){
    	return goodsInfoDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return goodsInfoDAO.deleteByPrimaryKey(id);
    }

	public int insert(GoodsInfo record){
    	return goodsInfoDAO.insert(record);
    }

	public int insertSelective(GoodsInfo record){
    	return goodsInfoDAO.insertSelective(record);
    }

	public List<GoodsInfo> selectByExample(GoodsInfoExample example){
    	return goodsInfoDAO.selectByExample(example);
    }

	public GoodsInfo selectByPrimaryKey(Integer id){
    	return goodsInfoDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(GoodsInfo record, GoodsInfoExample example){
    	return goodsInfoDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(GoodsInfo record, GoodsInfoExample example){
    	return goodsInfoDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(GoodsInfo record){
    	return goodsInfoDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(GoodsInfo record){
    	return goodsInfoDAO.updateByPrimaryKey(record);
    }


}
