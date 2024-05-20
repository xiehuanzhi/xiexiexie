package com.xiexie.service;

import com.xiexie.bean.GoodsInfo;
import com.xiexie.bean.GoodsInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsInfoService {
   
    long countByExample(GoodsInfoExample example);

    int deleteByExample(GoodsInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    List<GoodsInfo> selectByExample(GoodsInfoExample example);

    GoodsInfo selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

    int updateByExample(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

}
