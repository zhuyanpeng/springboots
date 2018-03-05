package com.study.cn.model;


import javax.persistence.*;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/3/5- 16:32
 * @Version: V1.0
 * @Modified By:
 **/
@Entity
@Table(name="permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column
    private String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
