package com.zrl.modules.api.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zrl.modules.api.entity.CustomerInfo;
import com.zrl.modules.api.mapper.CustomerInfoMapper;
import com.zrl.modules.api.service.CustomerInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 在时间之沙网站注册用户信息 服务实现类
 * </p>
 *
 * @author rose
 * @since 2018-09-14
 */
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements CustomerInfoService {

}
