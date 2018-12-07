package com.cnnnc.www.domain.user;

import javax.persistence.*;

/**
 * 作用说明：用户对象
 *
 * @author mirror.zhuyanpeng
 * @create 2017-09-13 0:55
 **/
@Entity
@Table(name="user")
public class UserPO {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public UserPO() {
    }

    public UserPO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
