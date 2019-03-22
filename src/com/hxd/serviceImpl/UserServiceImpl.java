package com.hxd.serviceImpl;

import com.hxd.dao.UserDao;
import com.hxd.entity.User;
import com.hxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User findUserByName(String username){
        return userDao.findUserByName(username);
    }

    public List<User> findUserList(){
        return userDao.findUserList();
    }

    public int add(User user){
        return userDao.add(user);
    }
    public int edit(User user){
        return userDao.edit(user);
    }
    public int delete(Long id){
        return userDao.delete(id);
    }
}
