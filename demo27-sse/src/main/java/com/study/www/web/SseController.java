package com.study.www.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: : 轮询后端控制
 * @date :Create in  2018/1/30 0030- 06:53
 * @Version: V1.0
 * @Modified By:
 **/
@Controller
public class SseController {

    @RequestMapping(value = "/push",produces = "text/event-stream")
    @ResponseBody
    public String push(){
        int i = new Random().nextInt();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:random:"+i+"\n\n";
    }

    @RequestMapping(value = "/sse",method = RequestMethod.GET)
    public String sse(){
        return "/sse";
    }
}
