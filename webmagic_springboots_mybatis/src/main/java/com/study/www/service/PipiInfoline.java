package com.study.www.service;

import com.study.www.entity.PipiInfo;
import com.study.www.entity.PipiInfoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.*;

/**
 * 作用说明：生意社
 *
 * @author mirror.zhuyanpeng
 * @create 2017-07-23 19:23
 **/
@Component
public class PipiInfoline implements Pipeline {
    @Autowired
    PipiService pipiService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<PipiInfo> pipiInfos=(List<PipiInfo>)resultItems.get("pipiInfos");
        HashMap<Integer,PipiInfoSimple> stringStringHashMap = new HashMap<>();//hashCode=AVG,date,className
       if (pipiInfos!=null&&pipiInfos.size()>0){
           for (PipiInfo pipiInfo : pipiInfos) {
               int i = pipiInfo.hashCode();
               if (stringStringHashMap.containsKey(i)){
                   PipiInfoSimple pipiSimple = stringStringHashMap.get(i);
                   int quoNum = pipiSimple.getOpecNum();
                   pipiSimple.setOpecNum(++quoNum);
                   float priceSum = pipiSimple.getPriceSum();
                   pipiSimple.setPriceSum( priceSum+pipiInfo.getPrice());
                   stringStringHashMap.put(i,pipiSimple);
               }else{
                   PipiInfoSimple pipiInfoSimple = new PipiInfoSimple();
                   pipiInfoSimple.setPriceSum(pipiInfo.getPrice());
                   pipiInfoSimple.setPriceUnit(pipiInfo.getPriceUnit().trim());
                   pipiInfoSimple.setClassName(pipiInfo.getClassName().trim());
                   pipiInfoSimple.setTime(pipiInfo.getTime().trim());
                   pipiInfoSimple.setOpecNum(1);
                   pipiInfoSimple.setSpec(pipiInfo.getSpec().trim());
                   stringStringHashMap.put(i,pipiInfoSimple);
               }
           }
           //价格四舍五入
           for (Integer integer : stringStringHashMap.keySet()) {
               float avgPrice = (stringStringHashMap.get(integer).getPriceSum()) / (stringStringHashMap.get(integer).getOpecNum());
               //小数部分
               float deci = avgPrice-(int)avgPrice;
               deci =Float.parseFloat(String.valueOf(Math.round(deci * 1000) * 0.001d)) ;
               stringStringHashMap.get(integer).setAvgPrice(avgPrice+deci);
           }
           ArrayList<PipiInfoSimple> pipiInfoSimples = new ArrayList<>();
           for (PipiInfoSimple pipiInfoSimple : stringStringHashMap.values()) {
               pipiInfoSimples.add(pipiInfoSimple);
           }
           pipiService.savePipiData(pipiInfos,pipiInfoSimples);
       }
    }
}
