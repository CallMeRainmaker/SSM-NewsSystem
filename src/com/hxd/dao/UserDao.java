package com.hxd.dao;

import com.hxd.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User findUserByName(String username);
    public List<User> findUserList();
    public int add(User user);
    public int edit(User user);
    public int delete(Long id);
}
