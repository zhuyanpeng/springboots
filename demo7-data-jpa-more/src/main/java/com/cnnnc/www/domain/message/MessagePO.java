package com.cnnnc.www.domain.message;

import javax.persistence.*;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-09-13 1:01
 **/
@Entity
//@Table(name = "message")
public class MessagePO {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    public MessagePO() {
    }

    public MessagePO(String name, String content) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
