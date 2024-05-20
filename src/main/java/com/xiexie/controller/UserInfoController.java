package com.xiexie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiexie.bean.UserInfo;
import com.xiexie.bean.UserInfoExample;
import com.xiexie.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/userInfo")
public class UserInfoController {
@Autowired(required = false)
private UserInfoService userInfoService;

//增
// 后端订单增加 -- 针对layui的 针对前端传 json序列化的
@RequestMapping("/insert")
public Map insert(@RequestBody UserInfo userInfo){ // orders 对象传参, 规则: 前端属性要和后台的属性一致!!!
Map map = new HashMap();
int i =  userInfoService.insertSelective(userInfo);
if(i>0){
map.put("code",200);
map.put("msg","添加成功");
return map;
}else{
map.put("code",400);
map.put("msg","添加失败,检查网络再来一次");
return map;
}
}


// 删
// 删除订单  根据 主键 id 删除
@RequestMapping("/deleteById")
public Map deleteById(@RequestParam(value = "id") Integer id) {
Map responseMap = new HashMap();
int i = userInfoService.deleteByPrimaryKey(id);
if (i > 0) {
responseMap.put("code", 200);
responseMap.put("msg", "删除成功");
return responseMap;
} else {
responseMap.put("code", 400);
responseMap.put("msg", "删除失败");
return responseMap;
}
}

// 批量删除
@RequestMapping("/deleteBatch")
public Map deleteBatch(@RequestParam(value = "idList[]") List<Integer> idList) {
    for (Integer integer : idList) {
    this.deleteById(integer);
    }
    Map responseMap = new HashMap();
    responseMap.put("code", 200);
    responseMap.put("msg", "删除成功");
    return responseMap;
    }


// 改
    // 修改订单
    @RequestMapping("/update")
    public Map update(@RequestBody UserInfo  userInfo) {
    Map map = new HashMap();
    int i = userInfoService.updateByPrimaryKeySelective( userInfo);
    if (i > 0) {
    map.put("code", 200);
    map.put("msg", "修改成功");
    return map;
    } else {
    map.put("code", 400);
    map.put("msg", "修改失败,检查网络再来一次");
    return map;
    }
    }

// 查--未分页
    // 全查
    @RequestMapping("/selectAll")
    public Map selectAll(){
    List<UserInfo> userInfos =  userInfoService.selectByExample(null);
        Map responseMap = new HashMap();
        responseMap.put("code", 0);
        responseMap.put("msg", "查询成功");
        responseMap.put("userInfos", userInfos);
        return responseMap;
        }

    @RequestMapping("/selectOne")
    public Map selectOne(UserInfo userInfo, HttpSession session){
        System.out.println("userInfo = " + userInfo);
    UserInfoExample example =new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(userInfo.getName());
        Map responseMap = new HashMap();
        List<UserInfo> userInfos =  userInfoService.selectByExample(example);
        if (userInfos.size()==1){
            String qianDuanPwd = userInfo.getPwd();
            if (qianDuanPwd.equals(userInfos.get(0).getPwd())){
                responseMap.put("code", 0);
                responseMap.put("msg", "密码正确");
                session.setAttribute("userInfo", userInfos.get(0));
            }else {
                responseMap.put("code", -2);
                responseMap.put("msg", "密码错误");
             //存入到 session 。。
            }
        }else {
            responseMap.put("code", -1);
            responseMap.put("msg", "你没账号");
        }
        return responseMap;
    }

// 查-- 查询+自身对象的查询 + 分页
// 分页查询
    @RequestMapping("/selectAllByPage") //    /api/userInfo/selectAllByPage
    public Map selectAllByPage(UserInfo userInfo, @RequestParam(value = "page", defaultValue = "1", required = true) Integer page,
    @RequestParam(value = "limit", required = true) Integer pageSize) {
    // 调用service 层   , 适用于 单表!!!
    PageHelper.startPage(page, pageSize);
    UserInfoExample example = new UserInfoExample();
    UserInfoExample.Criteria criteria = example.createCriteria();

    // if (null!=userInfo.getYYYYYYYY()&&!"".equals(userInfo.getYYYYYYY())){
    //    criteria.andPhoneEqualTo(userInfo.getPhone());   // 1
    //  }

    List<UserInfo> userInfosList = userInfoService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(userInfosList);
        long total = pageInfo.getTotal();
        Map responseMap = new HashMap();
        responseMap.put("code", 0);
        responseMap.put("msg", "查询成功");
        responseMap.put("pageInfo", pageInfo);
        responseMap.put("count", total);
        return responseMap;
        }



    }
