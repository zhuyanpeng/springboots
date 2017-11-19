package com.study.www.domain.mapper;

import com.study.www.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述:
 *
 * @outhor Administrator
 * @create 2017-11-19 08:56
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER u where account=#{account}")
    User findByAccount(@Param("account") String account);

    @Insert("insert into User values(#{user.id},#{user.account},#{user.name},#{user.sex})")
    int insertUser(@Param("user") User user);

    @Select("SELECT * FROM USER u where account like #{account}")
    List<User> selectByLikeAccount(@Param("account") String account);
}
