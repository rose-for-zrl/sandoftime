package com.zrl.modules.api.service;

import com.zrl.modules.api.entity.CustomerBindingInfo;
import com.baomidou.mybatisplus.service.IService;
import com.zrl.modules.api.entity.CustomerInfo;

/**
 * <p>
 * 注册客户绑定信息 服务类
 * </p>
 *
 * @author rose
 * @since 2018-09-15
 */
public interface CustomerBindingInfoService extends IService<CustomerBindingInfo> {

    boolean saveBindingCertNo(CustomerInfo customerInfo, CustomerBindingInfo customerBindingInfo);
}
