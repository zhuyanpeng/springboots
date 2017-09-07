package com.example.demo3swagger2restful.web;

import com.example.demo3swagger2restful.entity.TeacherDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作用说明：
 *
 * @author mirror.zhuyanpeng
 * @create 2017-08-25 0:12
 **/
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    static Map<Integer,TeacherDto> map=new HashMap<Integer,TeacherDto>();
    @ApiOperation(value = "获得老师列表",notes = "我不知道你在想森么")
    @GetMapping("")
    public List<TeacherDto> getTeacherList(){
        List<TeacherDto> teacherDtos = new ArrayList<>(map.values());
        return  teacherDtos;
    }
}
