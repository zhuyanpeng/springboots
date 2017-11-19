package com.study.www.domain.mapper;

import com.study.www.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Update("Update User set sex=#{sex,jdbcType=INTEGER} where  account=#{account,jdbcType=VARCHAR} AND name=#{name,jdbcType=VARCHAR}")
    int updateSexByAccountAndName(Map<String,Object> map);
    @Delete("delete FROM user where id=#{id,jdbcType=INTEGER}")
    void delete(Long id);

    @Select("select account,name from User where id=#{id,jdbcType=INTEGER}")
    @Results({
            @Result(property = "account",column = "account"),
            @Result(property = "name",column = "name")
    })
    Map findById(Long id);


}
