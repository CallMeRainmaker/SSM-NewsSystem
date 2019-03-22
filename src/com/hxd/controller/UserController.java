package com.hxd.controller;

import com.github.pagehelper.util.StringUtil;
import com.hxd.entity.User;
import com.hxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(User user){
        Map<String,String> map = new HashMap<>();
        if(user == null){
            map.put("type","error");
            map.put("msg","用户不存在");
            return map;
        }
        if(StringUtil.isEmpty(user.getUsername())){
            map.put("type","error");
            map.put("msg","请填写用户名");
            return map;
        }
        if(StringUtil.isEmpty(user.getPassword())){
            map.put("type","error");
            map.put("msg","请填写密码");
            return map;
        }
        if(userService.add(user)<=0){
            map.put("type","error");
            map.put("msg","添加失败");
            return map;
        }
        map.put("type","success");
        map.put("msg","添加成功");
        return map;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> edit(User user){
        Map<String,String> map = new HashMap<>();
        if(user == null){
            map.put("type","error");
            map.put("msg","用户不存在");
            return map;
        }
        if(StringUtil.isEmpty(user.getUsername())){
            map.put("type","error");
            map.put("msg","请填写用户名");
            return map;
        }
        if(StringUtil.isEmpty(user.getPassword())){
            map.put("type","error");
            map.put("msg","请填写密码");
            return map;
        }
        if(userService.edit(user)<=0){
            map.put("type","error");
            map.put("msg","修改失败");
            return map;
        }
        map.put("type","success");
        map.put("msg","修改成功");
        return map;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> delete(Long id){
        Map<String,String> map = new HashMap<>();
        if(id == null){
            map.put("type","error");
            map.put("msg","请选择用户");
            return map;
        }
        if(userService.delete(id)<=0){
            map.put("type","error");
            map.put("msg","删除失败");
            return map;
        }
        map.put("type","error");
        map.put("msg","删除成功");
        return map;
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserList(){
        Map<String,Object> map = new HashMap<>();
        List<User> list = userService.findUserList();
        if(list == null){
            return null;
        }
        map.put("rows",list);
        return map;
    }
}
