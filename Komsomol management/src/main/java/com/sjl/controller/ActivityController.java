package com.sjl.controller;

import com.sjl.domain.Activity;
import com.sjl.domain.User;
import com.sjl.service.ActivityService;
import com.sjl.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;
    //我把之前UserController那种冗长频繁调用业务层的都改了，直接写好放到业务层
    //不知道对不对，等后面接着学再看看

    //增加活动
    @PostMapping
    public Boolean save(@RequestBody Activity activity) {
        return activityService.save(activity);
    }

    //删除活动
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return activityService.delete(id);
    }

    //修改活动
    @PutMapping
    public Boolean update(HttpSession session, @RequestBody Activity activity) {
        //从session读属性user
        User user = (User) session.getAttribute("user");
        //用user的身份证读其他信息
        //每次都读两次，并且还得调用用户业务层，下次把组织id存在session里！！！！！
        user = userService.getByCard(user.getCard());
        activity.setOrganization(user.getOrganization());
        return activityService.update(activity);
    }

    //根据团组织获取活动列表
    @GetMapping
    public List<Activity> getAllByOrg(HttpSession session) {
        //从session读属性user
        User user = (User) session.getAttribute("user");
        //用user的身份证读其他信息
        //每次都读两次，并且还得调用用户业务层，下次把组织id存在session里！！！！！
        user = userService.getByCard(user.getCard());
        return activityService.getAllByOrg(user.getOrganization());
    }

    //根据时间查询活动
    @GetMapping("/{date}")
    public List<Activity> getAllByDate(HttpSession session, @PathVariable String date) {
        //从session读属性user
        User user = (User) session.getAttribute("user");
        //用user的身份证读其他信息
        //每次都读两次，并且还得调用用户业务层，下次把组织id存在session里！！！！！
        user = userService.getByCard(user.getCard());
        System.out.println("getAllByDate"+date);
        return activityService.getAllByDate(user.getOrganization(), date);
    }
}
