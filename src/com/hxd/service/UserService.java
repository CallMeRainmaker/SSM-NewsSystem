package com.hxd.service;

import com.hxd.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    public User findUserByName(String username);
    public List<User> findUserList();
    public int add(User user);
    public int edit(User user);
    public int delete(Long id);
}
