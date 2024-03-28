package com.sjl.service.impl;

import com.sjl.dao.OrganizationDao;
import com.sjl.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public String getById(Integer id) {
        return organizationDao.getById(id);
    }

    @Override
    public Integer getByName(String name) {
        return organizationDao.getByName(name);
    }
}
