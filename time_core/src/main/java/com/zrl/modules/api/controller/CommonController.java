package com.zrl.modules.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
/**
 * 通用接口
 */
public class CommonController {
    @GetMapping(value = "lose")
    @ApiOperation(value = "普通错误页面")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/common/error");
        return modelAndView;
    }
}
