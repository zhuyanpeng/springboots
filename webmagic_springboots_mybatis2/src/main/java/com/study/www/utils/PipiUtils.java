package com.study.www.utils;

import com.study.www.entity.PipiUpDownEntity;
import com.study.www.entity.PipiUpDownExplain;
import org.jsoup.nodes.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.selector.AndSelector;
import us.codecraft.webmagic.selector.LinksSelector;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.selector.Selector;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * PipiUtils: 单品对象的工具类
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/25    17:47
 **/
@Configuration
public class PipiUtils {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    public  static  final  String PIPIUPDOWNENTITY="pipiUpDownEntity";
    public  static  final  String PIPIUPDOWNEXPLAIN="pipiUpDownExplain";

    public  Map<String,Object> getPiPiInfosBySelectable(Selectable selectable, List<String> resultDay){
        try{
            List<Selectable> nodes = selectable.xpath("//table[@bgcolor='#C9D8FF']").nodes();
            if (nodes==null||nodes.size()==0){
                return null;
            }

            //如今只支持一个
            String time = resultDay.get(0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
            Date date = new SimpleDateFormat("MM-dd").parse(time.substring(5,time.length()));
            //表单 .xpath("/html/body/div[9]/div[1]/div[2]/table")
            List<Selectable> tables = selectable.xpath("//tbody").xpath("/tbody/tr").nodes();

            //表单标题
            List<Selectable> titleTable = tables.get(0).xpath("/tr/td/").nodes();
            //标题map
            Map<String, Integer> order = new HashMap<>();
            for (int i = 0; i < titleTable.size(); i++) {
                String titleStr = titleTable.get(i).toString();
                titleStr=matcherRegex(titleStr);
                if (titleStr.contains("价格")){
                    Date parse = simpleDateFormat.parse(titleStr.split("价格")[0]);
                    if (date.getTime()==parse.getTime()){
                        order.put(titleStr,i);
                    }
                }else {
                    order.put(titleStr,i);
                }
            }
            //按照商品、行业、价格、单位、日涨跌、同比涨跌、构建一个顺序表以方便取用
            Integer[] orderArr = new Integer[6];
            for (String key : order.keySet()) {
                if ("商品".equals(key)){
                    orderArr[0]=order.get(key);
                }else{
                    if ("行业".equals(key)){
                        orderArr[1]=order.get(key);
                    }else{
                        if (key.contains("价格")){
                            orderArr[2]=order.get(key);
                        }else{
                            if (key.equals("单位")){
                                orderArr[3]=order.get(key);
                            }else{
                                if (key.equals("日涨跌")){
                                    orderArr[4]=order.get(key);
                                }else{
                                    orderArr[5]=order.get(key);
                                }
                            }
                        }
                    }
                }
            }
            //假设上面是正确的那么上面就应该是["商品",0],["行业",1]
            //去获得内容
            List<PipiUpDownEntity> pipiUpDownEntities = new ArrayList<>();
            List<String> list;
            for (int i = 2; i < tables.size(); i++) {
                nodes = tables.get(i).xpath("/tr/").nodes();
                PipiUpDownEntity pipiUpDownEntity = new PipiUpDownEntity(time,
                        matcherRegex(nodes.get(orderArr[0]).get()),
                        matcherRegex(nodes.get(orderArr[1]).get()),
                        matcherRegex(nodes.get(orderArr[2]).get()),
                        matcherRegex(nodes.get(orderArr[3]).get()),
                        matcherRegex(nodes.get(orderArr[4]).get()),
                        matcherRegex(nodes.get(orderArr[5]).get())
                );
                pipiUpDownEntities.add(pipiUpDownEntity);
            }
            Map<String,Object> map=new HashMap<>();
            //每日说法
            PipiUpDownExplain pipiUpDownExplain=getPipiUpDownExplain(selectable,time);
            map.put(PIPIUPDOWNENTITY,pipiUpDownEntities);
            map.put(PIPIUPDOWNEXPLAIN,pipiUpDownExplain);
            return map;
        }catch (Exception e){
            logger.error("PipiUtils.getPiPiInfosBySelectable有误"+e.getMessage());
        }
        return null;
    }

    private static PipiUpDownExplain getPipiUpDownExplain(Selectable selectable, String time) {
        //根据样式去获得内容
        PipiUpDownExplain pipiUpDownExplain = new PipiUpDownExplain();
        String rankName = selectable.$("div.name","text").toString();
        pipiUpDownExplain.setRankName(rankName);
        StringBuffer stringBuffer = new StringBuffer();
        for (Selectable text : selectable.css("div.det_main,div.det_main2", "text").nodes()) {
          stringBuffer.append(text.get().trim());
        }
        pipiUpDownExplain.setExplain(stringBuffer.toString());
        pipiUpDownExplain.setTime(time);
        return  pipiUpDownExplain;
    }
    public static String matcherRegex(String str){
        //HTML去除正则
        String REGEX_HTML = "<[^>]+>";
        //正则支持
        Pattern p_html = Pattern.compile(REGEX_HTML, Pattern.CASE_INSENSITIVE);
        return p_html.matcher(str).replaceAll("").trim();
    }
}
