package com.xiexie.dao;

import com.xiexie.bean.GoodsInfo;
import com.xiexie.bean.GoodsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsInfoDAO {
    long countByExample(GoodsInfoExample example);

    int deleteByExample(GoodsInfoExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    List<GoodsInfo> selectByExample(GoodsInfoExample example);

    GoodsInfo selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

    int updateByExample(@Param("record") GoodsInfo record, @Param("example") GoodsInfoExample example);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}