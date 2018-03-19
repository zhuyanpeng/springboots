package com.study.www.service;

import com.study.www.mapper.PipiUpDownExplainMapper;
import com.study.www.utils.PipiUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * DzspProcessorService: 大宗商品刷选下载器
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/25    17:40
 **/
@Component
@PropertySource("classpath:application.properties")
public class DzspProcessorService implements PageProcessor{
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Value("${dzsp.resultDay}")
    private List<String> resultDay;
    @Autowired
    PipiUtils pipiUtils;
    @Value("${dzsp.url}")
    private String url;
    @Autowired
    private PipiUpDownExplainMapper pipiUpDownExplainMapper;

    public static String KEY="pipis";

    private void setResultDay(List<String> resultDay) {
        int w;
        if (StringUtils.isNotBlank(resultDay.get(0).split(";")[0])) {
            if(resultDay.size()==1){
                String[] split = resultDay.get(0).split(";");
                resultDay= new ArrayList<>();
                for (String s : split) {
                    if(StringUtils.isNotBlank(s.trim())){
                        resultDay.add(s.trim());
                    }
                }
            }
        }else{
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            cal.setTime(date);
            w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w ==1){
                cal.add(Calendar.DATE, -3);//当前时间前去一个天，即一个月前的时间
            }else{
                cal.add(Calendar.DATE, -1);
            }
            Date time = cal.getTime();
            String format = simpleDateFormat.format(time);
            resultDay = new ArrayList<>();
            resultDay.add(format);
        }
        this.resultDay = resultDay;
    }
    //网站需求
    private Site site=Site.me()
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.27.1 (KHTML, like Gecko) Version/5.1.2 Safari/534.52.7")
            .setRetrySleepTime(2)
            .setSleepTime(2000)
            .setRetryTimes(10)
            .setCharset("utf-8");

    @Override
    public void process(Page page) {
        try {
            List<String> all =new ArrayList<>();
            //此处的查找方式
            //1、首先通过XPath去找到期货篇的div组
            //2、根据正则:http://top.100ppi.com/\w[\w,]*/detail-day---\w[\w,]*.html 去查找所有规则符合http://top.100ppi.com/任意/detail-day---任意.html的
            page.addTargetRequests(page.getHtml().xpath("/html/body/div[9]/div[1]/div[2]").links().regex("http://top.100ppi.com/\\w[\\w,]*/detail-day---\\w[\\w,]*.html").all());
            Selectable selectable = page.getHtml();
            Map<String, Object> pipis = pipiUtils.getPiPiInfosBySelectable(selectable, resultDay);
            page.putField(DzspProcessorService.KEY,pipis);
        } catch (Exception e) {
            logger.error("DzspProcessorService.process"+e.getMessage());
        }
    }

    private boolean isExistData(List<String> resultDay) {
        int count;
        for (String time : resultDay) {
            count = pipiUpDownExplainMapper.queryCountByTime(time);
            if (count<10){
                return false;
            }
        }
        return true;
    }


    @Override
    public Site getSite() {
        return site;
    }

    public void start(DzspProcessorService processor, PipiInfoline pipiInfoline) {
        //配置分析
        setResultDay(resultDay);
        //是否有数据有的话直接杀死
        if(isExistData(resultDay)){
            logger.warn("数据库中已存在！系统关闭!");
            System.exit(0);
        }
        Spider.create(processor)
                .addUrl(url)
                .addPipeline(pipiInfoline)
                .thread(5)
                .run();
    }
}
