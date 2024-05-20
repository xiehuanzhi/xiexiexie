package com.xiexie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import com.xiexie.bean.GoodsInfo;
import com.xiexie.bean.GoodsInfoExample;
import com.xiexie.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/goodsInfo")
public class GoodsInfoController{
@Autowired(required = false)
private GoodsInfoService goodsInfoService;

//增
// 后端订单增加 -- 针对layui的 针对前端传 json序列化的
@RequestMapping("/insert")//  /api/goodsInfo//insert
public Map insert(@RequestBody GoodsInfo goodsInfo){ // orders 对象传参, 规则: 前端属性要和后台的属性一致!!!
Map map = new HashMap();
int i =  goodsInfoService.insertSelective(goodsInfo);
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
@RequestMapping("/deleteById")   //   /api/goodsInfo//deleteById
public Map deleteById(@RequestParam(value = "id") Integer id) {
Map responseMap = new HashMap();
int i = goodsInfoService.deleteByPrimaryKey(id);
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
    @RequestMapping("/update") //    /api/goodsInfo/update
    public Map update(@RequestBody GoodsInfo  goodsInfo) {
    Map map = new HashMap();
    int i = goodsInfoService.updateByPrimaryKeySelective( goodsInfo);
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
    List<GoodsInfo> goodsInfos =  goodsInfoService.selectByExample(null);
        Map responseMap = new HashMap();
        responseMap.put("code", 0);
        responseMap.put("msg", "查询成功");
        responseMap.put("goodsInfos", goodsInfos);
        return responseMap;
        }
    @RequestMapping("/selectPage")
    public Map selectPage(@RequestParam(value = "goodsType",defaultValue = "")String goodsType,
                                        @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize
                          ){
    GoodsInfoExample example =new GoodsInfoExample();
    PageHelper.startPage(pageNum,pageSize);
        GoodsInfoExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsTypeLike(goodsType);
        List<GoodsInfo> goodsInfos =  goodsInfoService.selectByExample(example);
        PageInfo<GoodsInfo> pageInfo =new PageInfo<>(goodsInfos);
        Map responseMap = new HashMap();
        if (goodsInfos.size()>0){
            responseMap.put("code", 0);
            responseMap.put("msg", "查询成功");
            responseMap.put("goodsInfos", pageInfo);
        }
        return responseMap;
    }

// 查-- 查询+自身对象的查询 + 分页
// 分页查询
    @RequestMapping("/selectAllByPage")  //  /api/goodsInfo/selectAllByPage
    public Map selectAllByPage(GoodsInfo goodsInfo, @RequestParam(value = "page", defaultValue = "1", required = true) Integer page,
    @RequestParam(value = "limit", required = true) Integer pageSize,@RequestParam(value = "name",defaultValue = "") String name) {
    // 调用service 层   , 适用于 单表!!!
    PageHelper.startPage(page, pageSize);
    GoodsInfoExample example = new GoodsInfoExample();
    GoodsInfoExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsTypeLike("%"+name+"%");
    // if (null!=goodsInfo.getYYYYYYYY()&&!"".equals(goodsInfo.getYYYYYYY())){
    //    criteria.andPhoneEqualTo(goodsInfo.getPhone());   // 1
    //  }

    List<GoodsInfo> goodsInfosList = goodsInfoService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(goodsInfosList);
        long total = pageInfo.getTotal();
        Map responseMap = new HashMap();
        responseMap.put("code", 0);
        responseMap.put("msg", "查询成功");
        responseMap.put("pageInfo", pageInfo);
        responseMap.put("count", total);
        return responseMap;
        }

    // 退出
    @RequestMapping("/logout") // /api/userInfo/logout
    // @ResponseBody
    public Map logout(HttpSession session){
        session.invalidate();
        Map codeMap = new HashMap();
        codeMap.put("code" , 0) ;
        codeMap.put("msg" , "退出成功") ;
        return codeMap;
    }

    }
