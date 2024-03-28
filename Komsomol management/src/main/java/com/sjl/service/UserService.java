package com.sjl.service;

import com.sjl.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
    public Boolean save(User user);

    public Boolean delete(String card);

    public Boolean update(User user);

    public Boolean updatePwd(User user);

    public User getByCard(String card);

    public Integer getId(User user);

    public List<User> getOrg(Integer organization);
}
