package com.study.www.utils;

import com.study.www.entity.PipiUpDownEntity;
import org.jsoup.nodes.Node;
import us.codecraft.webmagic.selector.Selectable;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * PipiUtils: 单品对象的工具类
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/25    17:47
 **/
public class PipiUtils {

    public static Map<String,Object> getPiPiInfosBySelectable(Selectable selectable, String className, List<String> resultDay){
        //如今只支持一个
        String time = resultDay.get(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String mMdd = new SimpleDateFormat("MM月dd日").format(simpleDateFormat.parse(time));
        List<Selectable> nodes = selectable.nodes();
        if (nodes==null||nodes.size()==0){
            return null;
        }
        List<Selectable> tables = selectable.xpath("/table/tbody/tr[1]/").nodes();

        //标题
        Map<Integer, String> order = new HashMap<>();
        List<Selectable> titleTabls = tables.get(0).nodes();
        for (int i = 0; i < titleTabls.size(); i++) {
            order.put(i,titleTabls.get(i).toString().split("b>")[1].split("<b")[0]);
        }
        //假设上面是正确的那么上面就应该是["商品",0],["行业",1]
        //去获得内容
        tables = selectable.xpath("/table/tbody/tr[2]/").nodes();
        for (Selectable table : tables) {
            table.xpath("tr")
        }
        ArrayList<PipiUpDownEntity> pipiUpDownEntities = new ArrayList<>();
        return null;
    }
    public static void checkTimeCodes(int timePoi,LinkedList<Node> hashSetBodyNodes){
        while (hashSetBodyNodes.size()<=timePoi){
            for (int poi = timePoi; poi > 0; poi--) {
                Node node = hashSetBodyNodes.get(poi-1);
                if (node.toString().split("-").length==3){
                    //假设规格为空
                    hashSetBodyNodes.add(node);
                }
            }
        }
    }
}
