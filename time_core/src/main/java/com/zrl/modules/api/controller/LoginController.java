package com.zrl.modules.api.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zrl.modules.api.dto.ResponseVo;
import com.zrl.modules.api.entity.CustomerInfo;
import com.zrl.modules.api.service.CustomerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 登陆相关接口
 * @author rose
 * @since 2018-09-14
 */
@RestController
@RequestMapping("/login/")
@Api(value = "/login" ,tags = "登陆/注册模块")
public class LoginController {

    @Autowired
    private CustomerInfoService customerInfoService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ApiOperation(value = "首页")
    @ApiIgnore
    public ModelAndView index(){
        //TODO 检查是否已经登陆，如果已经登陆则直接进入首页,先直接可进入首页  ,或者直接进入登陆页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/login");
        return modelAndView;
    }

    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    @ApiOperation(value = "登陆")
    public ResponseVo doLogin(@RequestParam("nickName") String nickName, @RequestParam("password") String password){
        //TODO 验证密码是否正确
        if(StringUtils.isEmpty(nickName) || StringUtils.isEmpty(password)){
            return ResponseVo.errorException("用户名和密码必填");
        }
        List<CustomerInfo> customerInfos = customerInfoService.selectList(new EntityWrapper<CustomerInfo>().eq("nick_name", nickName));
        if(!customerInfos.isEmpty() && customerInfos.get(0).getPassword().equals(password)){
            return ResponseVo.ok("index");
        }else{
            return ResponseVo.errorMsg("无效的用户名或密码错误");
        }
    }

    @PostMapping(value = "/signup")
    @ApiOperation(value = "注册用户")
    public ResponseVo postUser(@ModelAttribute CustomerInfo customerInfo) {
        if(null != customerInfo){
            customerInfo.setInsertTime(new Date());
            boolean b = customerInfoService.insert(customerInfo);
            return b ? ResponseVo.ok() : ResponseVo.errorMsg("注册失败");
        }else{
            return ResponseVo.errorMsg("注册失败");
        }
    }
}
