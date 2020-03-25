package com.example.start.service;

import com.example.start.Dao.UserDao;
import com.example.start.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userdao;

    public List<User> saveUser(List<User> users){
        List<User> user = userdao.saveAll(users);
        return user;
    }

    public List<User> finduser(String  name){
        List<User> users = userdao.findByName(name);
        return users;
    }
    public List<User> findAP(String  name){
        List<User> users = userdao.findByName(name);
        return users;
    }
    public void deleteUser(List<User> users){
         userdao.deleteAll(users);
    }
}
