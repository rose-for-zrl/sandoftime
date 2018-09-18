package com.zrl.modules.api.service.impl;

import com.zrl.common.constant.CustomerInfoConstant;
import com.zrl.modules.api.entity.CustomerBindingInfo;
import com.zrl.modules.api.entity.CustomerInfo;
import com.zrl.modules.api.mapper.CustomerBindingInfoMapper;
import com.zrl.modules.api.service.CustomerBindingInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zrl.modules.api.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 注册客户绑定信息 服务实现类
 * </p>
 *
 * @author rose
 * @since 2018-09-15
 */
@Service
public class CustomerBindingInfoServiceImpl extends ServiceImpl<CustomerBindingInfoMapper, CustomerBindingInfo> implements CustomerBindingInfoService {
    @Autowired
    private CustomerInfoService customerInfoService;//用户信息表
    @Override
    public boolean saveBindingCertNo(CustomerInfo customerInfo, CustomerBindingInfo customerBindingInfo) {
        if(customerInfoService.updateById(customerInfo)){
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("customerInfoId",customerBindingInfo.getCustomerInfoId());
            param.put("bindingType",customerBindingInfo.getBindingType());
            param.put("bindingState",CustomerInfoConstant.BindingState.NORMAL.getValue());
            List<CustomerBindingInfo> customerBindingInfos = this.selectByMap(param);
            if(customerBindingInfos.isEmpty()){
                return this.insert(customerBindingInfo);
            }
        }
        return false;
    }
}
