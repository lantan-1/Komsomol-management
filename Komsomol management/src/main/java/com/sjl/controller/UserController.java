package com.sjl.controller;

import com.sjl.domain.Organization;
import com.sjl.domain.User;
import com.sjl.service.OrganizationService;
import com.sjl.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrganizationService organizationService;


    //注册用户
    @PostMapping
    public boolean Save(@RequestBody Organization organization) {
        User user = organization.getUser();
        user.setOrganization(organizationService.getByName(organization.getName()));
        return userService.save(user);
    }


    //根据session里user的身份证获取组织与用户信息，返回格式如下
    /*
{
    "id": null,
    "name": "计科2109班团支部",
    "user": {
        "id": null,
        "organization": 9,
        "name": "单佳龙",
        "card": "130323200309023611",
        "ethnic": "汉族",
        "phone": "13383356583",
        "pwd": "2109"
    }
}
*/
    //查自己详细信息
    @GetMapping("/1")
    public Organization getByCard(HttpSession session) {
        //从session读属性user
        User user = (User) session.getAttribute("user");
        //用user的身份证读其他信息
        user = userService.getByCard(user.getCard());
        //用组织id读组织名
        String name=organizationService.getById(user.getOrganization());
        return new Organization(null,name,user);
    }
    //更新用户密码并且清除session
    @PutMapping("/pwd")
    public boolean updatePwd(HttpSession session,@RequestBody Organization organization){
        userService.updatePwd(organization.getUser());
        session.removeAttribute("user");
        return true;
    }
    //现在是前端根据登录的session判定密码，删除用户并且清除session，让前端跳到登陆页面
    //其实可以在访问一次数据库看看密码对不对，下次再改！！！
    @DeleteMapping
    public boolean delete(HttpSession session){
        String card=((User) session.getAttribute("user")).getCard();
        System.out.println(card);
        userService.delete(card);
        session.removeAttribute("user");
        return true;
    }
    //退出登录，清除一下session就ok，让前端跳到登陆页面
    @GetMapping("/logout")
    public boolean logout(HttpSession session){
        session.removeAttribute("user");
        return true;
    }
    //更新个人信息
    @PutMapping
    public boolean update(@RequestBody Organization organization){
        userService.update(organization.getUser());
        return true;
    }
    //查组织下全部成员
    @GetMapping
    public List<User> getOrg(HttpSession session) {
        //从session读属性user
        User user = (User) session.getAttribute("user");
        //用user的身份证读其他信息
        user = userService.getByCard(user.getCard());
        //用组织id读组织名
        List<User> userList = userService.getOrg(user.getOrganization());
        return userList;
    }
}
