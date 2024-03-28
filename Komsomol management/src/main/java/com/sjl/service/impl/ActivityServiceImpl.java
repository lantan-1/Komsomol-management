package com.sjl.service.impl;

import com.sjl.dao.ActivityDao;
import com.sjl.domain.Activity;
import com.sjl.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public Boolean save(Activity activity) {
        if (activityDao.getId(activity) == null) {
            activityDao.save(activity);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        activityDao.delete(id);
        return true;
    }

    @Override
    public Boolean update(Activity activity) {
        activityDao.update(activity);
        return true;
    }

    @Override
    public List<Activity> getAllByOrg(Integer organization) {
        return activityDao.getAllByOrg(organization);
    }

    @Override
    public List<Activity> getAllByDate(Integer organization, String date) {
        return activityDao.getAllByDate(organization,date);
    }
}
