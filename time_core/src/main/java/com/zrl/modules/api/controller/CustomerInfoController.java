package com.zrl.modules.api.controller;

import com.zrl.common.constant.CustomerInfoConstant;
import com.zrl.modules.api.dto.ResponseVo;
import com.zrl.modules.api.entity.CustomerBindingInfo;
import com.zrl.modules.api.entity.CustomerInfo;
import com.zrl.modules.api.service.CustomerBindingInfoService;
import com.zrl.modules.api.service.CustomerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 个人用户信息页面
 * @author rose
 *
 */
@RestController(value = "/user/")
@Api(value = "/user/" ,tags = "个人信息模块")
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;//用户信息表
    @Autowired
    private CustomerBindingInfoService customerBindingInfoService;//用户绑定信息表
    @PostMapping(value = "query")
    @ApiOperation(value = "根据id查询用户信息")
    public ResponseVo getCustomerUser(@RequestParam("userId") String userId){
        if(StringUtils.isEmpty(userId)){
            return  null;
        }
        return ResponseVo.ok(customerInfoService.selectById(userId));
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ApiOperation(value = "根据id修改用户信息")
    public ResponseVo putCustomerUser(@ModelAttribute CustomerInfo customerInfo){
        if(null == customerInfo || StringUtils.isEmpty(customerInfo.getUserId())){
            return ResponseVo.errorMsg("无效的用户");
        }
        CustomerInfo customerInfo_old = customerInfoService.selectById(customerInfo.getUserId());
        if(customerInfo_old == null ){
            return ResponseVo.errorMsg("无效的用户");
        }
        customerInfo_old.setAddress(customerInfo.getAddress() == null ? customerInfo_old.getAddress() : customerInfo.getAddress());
        customerInfo_old.setBirthday(customerInfo.getBirthday() == null ? customerInfo_old.getBirthday() : customerInfo.getBirthday());
        customerInfo_old.setCertNo(customerInfo.getCertNo() == null ? customerInfo_old.getCertNo() : customerInfo.getCertNo());
        customerInfo_old.setCity(customerInfo.getCity() == null ? customerInfo_old.getCity() : customerInfo.getCity());
        customerInfo_old.setNickName(customerInfo.getNickName() == null ? customerInfo_old.getNickName() : customerInfo.getNickName());
        customerInfo_old.setPassword(customerInfo.getPassword() == null ? customerInfo_old.getPassword() : customerInfo.getPassword());
        customerInfo_old.setProvince(customerInfo.getProvince() == null ? customerInfo_old.getProvince() : customerInfo.getProvince());
        customerInfo_old.setSex(customerInfo.getSex() == null ? customerInfo_old.getSex() : customerInfo.getSex());
        customerInfo_old.setState(customerInfo.getState() == null ? customerInfo_old.getState() : customerInfo.getState());
        customerInfo_old.setUpdateTime(new Date());
        boolean b = customerInfoService.updateById(customerInfo_old);
        return b ? ResponseVo.ok(customerInfo_old) : ResponseVo.errorMsg("修改失败");
    }

    @PostMapping(value = "queryBinding")
    @ApiOperation(value = "根据用户Id查询绑定关系")
    public ResponseVo queryBindingInfo(@RequestParam("userId") String userId){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("customerInfoId",userId);
        List<CustomerBindingInfo> customerBindingInfos = customerBindingInfoService.selectByMap(param);
        return ResponseVo.ok(customerBindingInfos);
    }

    @PostMapping(value = "bindingCertNo")
    @ApiOperation(value = "根据id绑定身份证信息")
    public ResponseVo bindingCertNo(@ModelAttribute CustomerInfo customerInfo){
        if(null == customerInfo || StringUtils.isEmpty(customerInfo.getUserId())){
            return ResponseVo.errorMsg("无效的用户");
        }
        CustomerInfo customerInfo_old = customerInfoService.selectById(customerInfo.getUserId());
        if(customerInfo_old == null ){
            return ResponseVo.errorMsg("无效的用户");
        }
        customerInfo_old.setRealName(customerInfo.getRealName());
        customerInfo_old.setCertNo(customerInfo.getCertNo());
        customerInfo_old.setBirthday(customerInfo.getBirthday() == null ? customerInfo_old.getBirthday() : customerInfo.getBirthday());
        customerInfo_old.setSex(customerInfo.getSex() == null ? customerInfo_old.getSex() : customerInfo.getSex());
        CustomerBindingInfo customerBindingInfo = new CustomerBindingInfo();
        customerBindingInfo.setCustomerInfoId(customerInfo_old.getUserId());
        customerBindingInfo.setBindingState(CustomerInfoConstant.BindingState.NORMAL.getValue());
        customerBindingInfo.setBindingType(CustomerInfoConstant.BindingType.CERTNO.getValue());
        customerBindingInfo.setBindingContent(customerInfo_old.getCertNo());
        customerBindingInfo.setInsertTime(new Date());
        boolean b = customerBindingInfoService.saveBindingCertNo(customerInfo_old,customerBindingInfo);
        return b? ResponseVo.ok() : ResponseVo.errorMsg("绑定身份证失败，请稍后重试");
    }

    @PostMapping(value = "bindingPhone")
    @ApiOperation(value = "根据id绑定手机号信息")
    public ResponseVo bindingPhone(@ModelAttribute CustomerBindingInfo customerBindingInfo){
        return null;
    }

    @PostMapping(value = "bindingEmail")
    @ApiOperation(value = "根据id绑定邮箱信息")
    public ResponseVo bindingEmail(@ModelAttribute CustomerBindingInfo customerBindingInfo){
        return null;
    }

    @PostMapping(value = "unbindEmailOrPhone")
    @ApiOperation(value = "根据id解除绑定邮箱、手机号信息")
    public ResponseVo unbindEmailOrPhone(@ModelAttribute CustomerBindingInfo customerBindingInfo){
        return null;
    }
}
