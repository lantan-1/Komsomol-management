package com.sjl.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjl.domain.User;
import com.sjl.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserService userService;
    private LineCaptcha captcha;

    //登录
    @PostMapping
    public boolean getId(HttpSession session, @RequestBody List<Object> list) {
        //应该写个包装类好了,或者只传身份证，密码，验证码
/*    public class UserYzm {
        private User user;
        private String yzm;
    }
*/      //json里的Object转String,Object转User
        //这里写的不好
        String yzm = String.valueOf(list.get(1)).substring(5, 9);
        User user = new ObjectMapper().convertValue(list.get(0), User.class);
        //先判断验证码是否匹配
        System.out.println(yzm);
        if (!yzm.equals(captcha.getCode())) return false;
        //存下session
        session.setAttribute("user", user);
        Integer userId = userService.getId(user);
        //判断身份证与密码是否匹配，匹配返回true，不匹配返回false
        boolean flag;
        flag = userId != null;
        return flag;
    }


    //先获取验证码
    @GetMapping
    public void getCode(HttpServletResponse response) {
        //定义图形验证码的长和宽
        captcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        //保存到本地
        //captcha.write("/img/captcha.png");
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            // 输出到页面
            captcha.write(response.getOutputStream());
            // 关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
