package com.study.www.web;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    List<SseEmitter> emitterList=new ArrayList<>();

    /**
     * 使用sse的时候需要注意new EventSource("/push"); 的访问路径需要给返回一个SseEmitter进行SSE的注册
     * @return
     */
    @GetMapping("push")
    public SseEmitter push(){
        SseEmitter sseEmitter = new SseEmitter();
        emitterList.add(sseEmitter);
        return sseEmitter;
    }
    @Scheduled(cron = "0/1 * * * * ?")
    public void cron(){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(new Date());
            emitterList.forEach((SseEmitter mitter)->{
                try {
                    mitter.send(format, MediaType.APPLICATION_JSON);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/sse",method = RequestMethod.GET)
    public String sse(){
        return "/sse";
    }
}
