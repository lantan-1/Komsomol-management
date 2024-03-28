package com.sjl.service.impl;

import com.sjl.dao.UserDao;
import com.sjl.domain.User;
import com.sjl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;

    @Override
    public Boolean save(User user) {
        if (userDao.getByCard(user.getCard())!=null) {
            return false;
        }
        userDao.save(user);
        return true;
    }

    @Override
    public Boolean delete(String card) {
        userDao.delete(card);
        return true;
    }

    @Override
    public Boolean update(User user) {
        userDao.update(user);
        return true;
    }

    @Override
    public Boolean updatePwd(User user) {
        userDao.updatePwd(user);
        return true;
    }

    @Override
    public User getByCard(String card) {
        return userDao.getByCard(card);
    }

    @Override
    public Integer getId(User user) {
        return userDao.getId(user);
    }

    @Override
    public List<User> getOrg(Integer organization) {
        return userDao.getOrg(organization);
    }
}
