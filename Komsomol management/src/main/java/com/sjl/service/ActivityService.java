package com.sjl.service;

import com.sjl.domain.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

public interface ActivityService {
    public Boolean save(Activity activity);

    public Boolean delete(Integer id);

    public Boolean update(Activity activity);

    public List<Activity> getAllByOrg(Integer organization);

    public List<Activity> getAllByDate(Integer organization, String date);
}
