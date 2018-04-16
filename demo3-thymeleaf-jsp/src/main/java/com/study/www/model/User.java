package com.study.www.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/4/16 0016- 11:30
 * @Version: V1.0
 * @Modified By:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private long age;

}
