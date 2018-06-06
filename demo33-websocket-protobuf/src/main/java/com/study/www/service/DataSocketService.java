package com.study.www.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author : Administrator.zhuyanpeng
 * @Description: : 数据请求服务
 * @date :Create in  2018/6/6 0006- 17:59
 * @Version: V1.0
 * @Modified By:
 **/
@ServerEndpoint("/data")
@Component
public class DataSocketService {
    private static CopyOnWriteArraySet<DataSocketService> webSocketSet=new CopyOnWriteArraySet<>();
    private Session session;

    //连接
    @OnOpen
    public void open(Session session){
        this.session=session;
        webSocketSet.add(this);
    }

    //关闭
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
    }
    //发送消息

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    @Scheduled(cron = "0/3 * * * * ?") // 每天的9点11点14点16点半运行一次
    public void scheduler(){
        Random random = new Random();
        String[] strs = new String[5];
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        for (int i = 0; i < 5; i++) {
            String format = decimalFormat.format(random.nextDouble());
            strs[i]=format;
        }
        for (DataSocketService dataSocketService : webSocketSet) {
            try {
                dataSocketService.sendMessage(Arrays.toString(strs));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
