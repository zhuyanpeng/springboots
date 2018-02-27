package com.study.www.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description: :
 * @date :Create in  2018/2/23- 15:02
 * @Version: V1.0
 * @Modified By:
 **/
@Entity
@Getter
@Setter
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String cron;

}
