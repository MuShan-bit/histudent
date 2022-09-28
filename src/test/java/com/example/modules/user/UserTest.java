package com.example.modules.user;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.modules.market.service.CommodityService;
import com.example.modules.user.mapper.UserMapper;
import com.example.modules.user.pojo.dto.Smss;
import com.example.modules.user.pojo.dto.UserInfoLt;
import com.example.modules.user.pojo.po.StuInfo;
import com.example.modules.user.pojo.po.User;
import com.example.modules.user.service.UserService;
import com.example.modules.user.utils.Anquan.LoginUser;
import com.example.modules.user.utils.Anquan.RedisCache;
import com.example.modules.user.utils.Consts;
import com.example.modules.websocket.entity.MegUser;
import com.example.modules.websocket.entity.MesssageWs;
import com.example.utils.R;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.python.modules._json._json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class UserTest {

//    @Autowired
//    UserService userServiceImpl;
//
    @Autowired
    UserMapper userMapperImpl;
//
//    @Autowired
//    CommodityService commodityServiceImpl;
//
//    @Test
//    void tes7(){
////        UserInfoLt userInfolt = userServiceImpl.getUserInfolt("1");
////        System.out.println("========= "+userInfolt);
//    }
//
//    @Test
//    void testas(){
////        List<CommodityVO> voList=commodityServiceImpl.getAllCommodityService();
//    }
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userServiceImpl;
    @Autowired
    RedisCache redisCache;


//    @Test
//    void SADas(){
//        ValueOperations operations=redisTemplate.opsForValue();
//        operations.set("qwq","444444444",9,TimeUnit.MINUTES);
//        Object o = operations.get("qwq");
//        System.out.println(o.toString());

//        redisTemplate.delete(Consts.LOGIN_USERS+"18876521895");
//        Object o = operations.get("qwq");
//        if (o==null){
//            System.out.println("saaaaasa");
//        }
//    }



//    @Test
//    void asdm9(){
//        String redisKey="login:299e9d153c3c3a4e8d8f7286d3d7db55";
//        Object s = redisCache.getCacheObject(redisKey);
//        LoginUser loginUser= JSON.parseObject(JSON.toJSONString(s),new TypeReference<LoginUser>() {});
//        System.out.println(loginUser);
//    }

//    @Test
//    void ashjkbm(){
//        redisTemplate.opsForHash().delete(Consts.LOGIN_USERS,"18110359126");
//    }

//    @Test
//    void as90(){
//        StuInfo stuInfo = userServiceImpl.getStuInfo("1552570983563436034");
//        System.out.println(stuInfo);
//    }

//    @Test
//    public void ASasa(){
//        redisTemplate.opsForHash().delete(Consts.LOGIN_USERS,"lt");
//    }
//    @Test
//    public void sada(){
//        ValueOperations<String,String> redis = redisTemplate.opsForValue();
//        String smslocal=redis.get("18876521895");
//        System.out.println(smslocal);
//    }
//    @Test
//    void dsa09ann(){
//
//    }

//    @Test
//    public void as9jd(){
//        redisTemplate.opsForValue().set("lt","66666666666",100,TimeUnit.SECONDS);
//        String o = (String) redisTemplate.opsForValue().get("lt");
//        System.out.println(o);
//    }

//    @Test
//    void ao98s(){
//        List<String> o = (List<String>) redisTemplate.opsForHash().get("xiaoyus", "huccct");
//        System.out.println(o);
//    }
//    @Test
//    void ppp(){
//
//        Set keys = redisTemplate.opsForHash().keys("huccct");
//        List<MegUser> megUserList=new ArrayList<>();
//        for (Object s:keys){
//            String x= (String) s;
//            MegUser megUser=new MegUser();
//            megUser.setUsername(x);
//            megUser.setHeadImg(userServiceImpl.getImgByUserName(x));
//
//            List<String> list= (List<String>) redisTemplate.opsForHash().get("huccct",x);
//            JSONObject jsonObject=JSONUtil.parseObj(list.get(0));
//            megUser.setText(jsonObject.getStr("text"));
//
//            megUserList.add(megUser);
//        }
//        System.out.println(megUserList);
//    }
//    @Test
//    void sda74ry(){
//        redisTemplate.opsForHash().delete("xiaoyus","huccct");
//        Set huccct = redisTemplate.opsForHash().keys("xiaoyus");
//        System.out.println(huccct);
//    }

}
