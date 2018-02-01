package com.study.www.web;

import com.study.www.conf.MyMvcConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/1/31- 11:22
 * @Version: V1.0
 * @Modified By:
 **/
@Controller
public class SseController1 {

    @RequestMapping(value = "/sse1",method = RequestMethod.GET)
    public String sse(){
        return "/stream";
    }

    @GetMapping("/bind")
    public SseEmitter bind(){
        return MyMvcConfig.addEmitter();
    }

}
