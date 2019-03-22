package com.hxd.controller;

import com.hxd.service.NewsRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsRangeService newsRangeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.addObject("NewsRangeList",newsRangeService.findList());
        modelAndView.setViewName("newsList");
        return modelAndView;
    }
}
