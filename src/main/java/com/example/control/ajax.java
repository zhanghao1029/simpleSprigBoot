package com.example.control;
import com.example.Dao.DefaultUser;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@EnableConfigurationProperties(DefaultUser.class)
@RestController
@RequestMapping("/ajax")
public class ajax {

    @Autowired
    private UserService iUser;
    @Autowired
    private DefaultUser defaultUser;

    @RequestMapping("addUser")
    public List<User>  add (@RequestParam(value = "name") String name,
                            @RequestParam(value = "age") Integer age){
        List<User> Allusers  = iUser.finduser(name);
        if(Allusers.size()>0){
            List message = new ArrayList();
            message.add("用户名已存在");
            return message;
        }
        User user = new User();
        user.setAge(age);
        user.setName(name);
        List<User> users = new ArrayList<>();
        users.add(user);
        List<User> userList = iUser.saveUser(users);
        return userList;
    };

    @RequestMapping("findUser")
    public String findUser(@RequestParam(value = "name") String name ){
        List<User> users  = iUser.finduser(name);
        String rname = users.get(0).getName();
        return rname;
    };

    @RequestMapping("deleteUser")
    public void delete(@RequestParam(value = "name") String name){
        List<User> users  = iUser.finduser(name);
        iUser.deleteUser(users);
    };

    @RequestMapping("updataUser")
    public void updata(@RequestParam(value = "name") String name){

    };
    @RequestMapping("test")
    public void Test(){
        String name = defaultUser.getName();
        System.out.println(name);
    }
}
