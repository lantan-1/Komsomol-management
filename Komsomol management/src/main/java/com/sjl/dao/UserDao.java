package com.sjl.dao;

import com.sjl.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Insert("insert into user values (null, #{organization}, #{name}, #{card}, #{ethnic}, #{phone}, #{pwd})")
    public void save(User user);

    @Delete("delete from user where card = #{card}")
    public void delete(String card);

    @Update("update user set name = #{name}, ethnic = #{ethnic}, phone = #{phone} where card = #{card}")
    public void update(User user);

    @Update("update user set pwd = #{pwd} where card = #{card}")
    public void updatePwd(User user);

    @Select("select organization, name, card, ethnic, phone, pwd from user where card = #{card}")
    public User getByCard(String card);

    @Select("select id from user where card = #{card} and pwd = #{pwd}")
    public Integer getId(User user);

    @Select("select organization, name, ethnic, phone from user where organization = #{organization}")
    public List<User> getOrg(Integer organization);
}
