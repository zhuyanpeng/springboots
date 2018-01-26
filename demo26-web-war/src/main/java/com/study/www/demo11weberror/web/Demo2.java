package com.study.www.demo11weberror.web;

import com.study.www.demo11weberror.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: json返回异常
 *
 * @outhor Administrator
 * @create 2017-10-08 17:21
 */
@RestController
public class Demo2 {
    @RequestMapping("/json")
    public String json() throws MyException {
        throw  new MyException("发生json错误!");
    }
}
