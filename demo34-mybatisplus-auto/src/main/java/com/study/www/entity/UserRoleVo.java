package com.study.www.entity;

import lombok.Data;

import java.util.List;

/**
 * @author : THINK.zhuyanpeng
 * @Description: : 用户复杂对象
 * @date :Create in  2018/11/29- 5:44
 * @Version: V1.0
 * @Modified By:
 **/
@Data
public class UserRoleVo extends User{
    List<Role> roles;
}
