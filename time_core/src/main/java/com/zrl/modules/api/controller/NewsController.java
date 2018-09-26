package com.zrl.modules.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/news/")
/**
 * 所有新闻信息获取
 */
public class NewsController {

    @GetMapping(value = "{id}")
    @ApiOperation(value = "获取新闻信息页面")
    public ModelAndView getNews(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/news/"+id);
        return modelAndView;
    }
}
