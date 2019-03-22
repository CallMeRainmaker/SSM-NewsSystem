package com.hxd.controller;

import com.github.pagehelper.util.StringUtil;
import com.hxd.entity.News;
import com.hxd.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/news")
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("/newsList");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(News news){
        Map<String,String> map = new HashMap<>();
        if(news == null){
            map.put("type","error");
            map.put("msg","请添加正确分类信息");
            return map;
        }
        if(StringUtil.isEmpty(news.getName())){
            map.put("type","error");
            map.put("msg","分类名称不能为空");
            return map;
        }
        if(newsService.add(news) <= 0){
            map.put("type","error");
            map.put("msg","分类添加失败");
            return map;
        }
        map.put("type","success");
        map.put("msg","添加成功");
        return map;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> edit(News news){
        Map<String,String> map = new HashMap<>();
        if(news == null){
            map.put("type","error");
            map.put("msg","请编辑正确分类信息");
            return map;
        }
        if(StringUtil.isEmpty(news.getName())){
            map.put("type","error");
            map.put("msg","分类名称不能为空");
            return map;
        }
        if(newsService.edit(news) <= 0){
            map.put("type","error");
            map.put("msg","分类编辑失败");
            return map;
        }
        map.put("type","success");
        map.put("msg","编辑成功");
        return map;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> delete(Long id){
        Map<String,String> map = new HashMap<>();
        if(id == null){
            map.put("type","error");
            map.put("msg","ID不存在");
            return map;
        }
        try{
            if(newsService.delete(id) <= 0){
                map.put("type","error");
                map.put("msg","删除失败");
                return map;
            }
        }catch (Exception e){
            map.put("type","error");
            map.put("msg","该分类下有新闻信息，不能删除");
            return map;
        }
        map.put("type","success");
        map.put("msg","删除成功");
        return map;
    }

    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getList(){
        Map<String,Object> map = new HashMap<>();
        List<News> list = newsService.findList();
        if(list == null){
            map.put("type","error");
            map.put("msg","列表为空");
            return map;
        }
        map.put("rows",list);
        return map;
    }
}
