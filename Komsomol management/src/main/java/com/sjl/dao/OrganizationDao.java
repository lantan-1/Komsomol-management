package com.sjl.dao;

import com.sjl.domain.Organization;
import com.sjl.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDao {
    @Insert("insert into organization values (#{name})")
    public void save(String name);

    @Delete("delete from organization where name = #{name}")
    public void delete(String name);

    @Update("update organization set name = #{name} where id = #{id}")
    public void update(Organization organization);


    /*目前只用到这一个，别的还没测*/
    @Select("select name from organization where id = #{id}")
    public String getById(Integer id);

    @Select("select id from organization where name = #{name}")
    public Integer getByName(String name);
}
