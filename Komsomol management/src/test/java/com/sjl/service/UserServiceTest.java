package com.sjl.service;

import com.sjl.config.SpringConfig;
import com.sjl.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(classes = SpringConfig.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetId(){
        User user=new User(null,null,null,"610429200209045117",null,null,"1111");
        Integer id = userService.getId(user);
        if (id==null){
            System.out.println("没有该用户");
        }else System.out.println("存在该用户id="+id);
    }
    @Test
    public void testGetByCard() {
        User user = userService.getByCard("130323200309023611");
        System.out.println(user);
    }

    @Test
    public void testGetAll() {
        List<User> userList = userService.getOrg(9);
        System.out.println(userList);
    }

}
