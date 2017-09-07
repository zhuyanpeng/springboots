package com.example.demo1moreconfig;

import com.example.demo3swagger2restful.entity.BookBean;
import com.example.demo3swagger2restful.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作用说明：书籍浏览器
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-22 0:35
 **/
@RestController
@EnableConfigurationProperties({BookBean.class,UserDto.class})
public class BookControl {
    @Autowired
    private BookBean book;
    @Autowired
    private UserDto userDto;
    @GetMapping("/book1")
    public String book(){
        return "又在看黄书"+book.getName()+userDto.getNames();
    }


}
