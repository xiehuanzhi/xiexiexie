package com.xiexie.service;

import com.xiexie.bean.UserInfo;
import com.xiexie.bean.UserInfoExample;
import com.xiexie.dao.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired(required = false)
	private UserInfoDAO userInfoDAO;
	public long countByExample(UserInfoExample example){
    	return userInfoDAO.countByExample(example);
    }

	public int deleteByExample(UserInfoExample example){
    	return userInfoDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return userInfoDAO.deleteByPrimaryKey(id);
    }

	public int insert(UserInfo record){
    	return userInfoDAO.insert(record);
    }

	public int insertSelective(UserInfo record){
    	return userInfoDAO.insertSelective(record);
    }

	public List<UserInfo> selectByExample(UserInfoExample example){
    	return userInfoDAO.selectByExample(example);
    }

	public UserInfo selectByPrimaryKey(Integer id){
    	return userInfoDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(UserInfo record, UserInfoExample example){
    	return userInfoDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(UserInfo record, UserInfoExample example){
    	return userInfoDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(UserInfo record){
    	return userInfoDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(UserInfo record){
    	return userInfoDAO.updateByPrimaryKey(record);
    }


}
