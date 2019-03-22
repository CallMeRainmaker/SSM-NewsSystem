package com.hxd.controller;

import com.hxd.entity.User;
import com.hxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView){
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value = "/loginAct",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> lognAct(String username,String password, HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        if(username == null){
            map.put("type","error");
            map.put("msg","用户不存在");
            return map;
        }
        if(username == null){
            map.put("type","error");
            map.put("msg","用户名不能为空");
            return map;
        }
        if(password == null){
            map.put("type","error");
            map.put("msg","密码不能为空");
            return map;
        }
        User user1 = userService.findUserByName(username);
        if(user1 == null){
            map.put("type","error");
            map.put("msg","用户不存在");
            return map;
        }
        if(!user1.getPassword().equals(password)){
            map.put("type","error");
            map.put("msg","密码错误");
            return map;
        }
        request.getSession().setAttribute("user",user1);
        map.put("type","success");
        map.put("msg","登陆成功");
        return map;
    }
}
