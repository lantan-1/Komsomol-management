package com.sjl.dao;

import com.sjl.domain.Activity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ActivityDao {
    @Insert("insert into activity values (null, #{organization}, #{type}, #{date}, #{host}, #{place}, #{content})")
    public void save(Activity activity);

    @Delete("delete from activity where id = #{id}")
    public void delete(Integer id);

    @Update("update activity set organization = #{organization}, type = #{type}, date = #{date}, host = #{host}, place = #{place}, content = #{content} where id = #{id}")
    public void update(Activity activity);

    @Select("select id from activity where organization = #{organization} and type = #{type} and date = #{date} and host = #{host} and place = #{place} and content = #{content}")
    public Integer getId(Activity activity);

    @Select("select * from activity where organization = #{organization}")
    public List<Activity> getAllByOrg(Integer organization);

/*  mybatis纯注解传多参数
错误写法：
    @Select("select * from activity where organization = #{organization} and date = #{date}")
    public List<Activity> getAllByDate(Integer organization,String date);
异常如下：
    org.apache.ibatis.binding.BindingException:
          Parameter 'organization' not found.
          Available parameters are [arg1, arg0, param1, param2]
正确写法如下：
*/
    @Select("select * from activity where organization = #{organization} and date = #{date}")
    public List<Activity> getAllByDate(@Param("organization") Integer organization,@Param("date") String date);
}
