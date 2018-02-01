package com.study.www.conf;

import com.study.www.Message;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: :
 * @date :Create in  2018/1/30 0030- 06:57
 * @Version: V1.0
 * @Modified By:
 **/
@Component
public class MyMvcConfig {
    //维护一个可以变的List数组来管理链接
    private volatile  static List<SseEmitter> emitters= new ArrayList<SseEmitter>();

    public static SseEmitter addEmitter(){
        SseEmitter sseEmitter = new SseEmitter();
        emitters.add(sseEmitter);
        sseEmitter.onCompletion(() -> emitters.remove(sseEmitter));
        return sseEmitter;
    }

    public static void removeEmitter(){
    }
    @Scheduled(cron = "0/5 * 14 * * ?")
    public  void subMessage(){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            for (int i = 0; i < 10; i++) {
                if(emitters.size()>0){
                    Thread.sleep(2000);
                    emitters.forEach((SseEmitter emitter)->{
                        try {
                            emitter.send(new Message("from", dateFormat.format(new Date())), MediaType.APPLICATION_JSON);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
