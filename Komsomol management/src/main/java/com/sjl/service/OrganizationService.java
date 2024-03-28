package com.sjl.service;

import com.sjl.domain.User;

public interface OrganizationService {
    public String getById(Integer id);

    public Integer getByName(String name);
}
