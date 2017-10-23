package com.study.www.utils;

import com.study.www.entity.PipiInfo;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * PipiUtils: 单品对象的工具类
 *
 * @auther : Administrator.zhuyanpeng
 * @date : 2017/7/25    17:47
 **/
public class PipiUtils {

    public static List<PipiInfo> getPiPiInfosBySelectable(Selectable selectable, String className, List<String> resultDay){
        List<Selectable> nodes = selectable.nodes();
        ArrayList<PipiInfo> pipiInfos = new ArrayList<>();
        //根据标题去判断单品的顺序
        HashMap<String,Integer> hashMapTables = new HashMap<String,Integer>();
        Document tableDoc = Jsoup.parseBodyFragment(nodes.get(0).toString());
        int a=0;
        for (Node tableNode :  tableDoc.body().childNodes()) {
            if (StringUtils.isNotBlank(tableNode.toString().trim())){
                hashMapTables.put(tableNode.toString(),a++);
            }
        }
        //内容选择
        LinkedList<Node> hashSetBodyNodes = null;
        PipiInfo pipiInfo=null;
        for (int i = 1; i < nodes.size(); i++) {
            Selectable bodyNode = nodes.get(i);
            hashSetBodyNodes = new LinkedList<>();
            Document bodyDocument = Jsoup.parseBodyFragment(bodyNode.toString());
            for (Node node : bodyDocument.body().childNodes()) {
                if (StringUtils.isNotBlank(node.toString())&&StringUtils.indexOf(node.toString(),"<img")==-1){
                    hashSetBodyNodes.add(node);
                }
            }
            pipiInfo= new PipiInfo();
            pipiInfo.setClassName(className.trim());
            int timeCor=hashMapTables.get("发布时间")<0?hashMapTables.get("时间"):hashMapTables.get("发布时间");
            i=resultDay.size()==0?nodes.size():i;
            //补位
            PipiUtils.checkTimeCodes(timeCor,hashSetBodyNodes);
            String time = hashSetBodyNodes.get(timeCor).toString();
            if (resultDay.size()==0||resultDay.contains(time)){
                pipiInfo.setTime(time.trim());
                int priceOrgCor=hashMapTables.get("报价机构")<0?hashMapTables.get("报价单位"):hashMapTables.get("报价机构");
                pipiInfo.setPriceOrg(hashSetBodyNodes.get(priceOrgCor).childNode(1).childNode(0).toString().trim());
                int priceTypleCor=hashMapTables.get("报价类型")<0?hashMapTables.get("价格类型"):hashMapTables.get("报价类型");
                pipiInfo.setPriceTyple(hashSetBodyNodes.get(priceTypleCor).toString().trim());
                int priceCor=hashMapTables.get("报价")<0?hashMapTables.get("价格"):hashMapTables.get("报价");
                String priceCorStr = hashSetBodyNodes.get(priceCor).toString();
                String priceUnit=null;
                float priceCore=0.0F;
                //单元和价格分离
                try {
                    String[] split = priceCorStr.split("元/");
                    priceCore = Float.valueOf(split[0]);
                    priceUnit="元/"+split[1];
                } catch (NumberFormatException e) {
                    String[] split = priceCorStr.split("美元/");
                    priceCore = Float.valueOf(split[0]);
                    priceUnit="美元/"+split[1];
                }
                pipiInfo.setPrice(priceCore);
                pipiInfo.setPriceUnit(priceUnit.trim());
                int specCor=hashMapTables.get("规格")<0?hashMapTables.get("商品名称"):hashMapTables.get("规格");
                String specCorStr= hashSetBodyNodes.get(specCor).childNodes().size() <= 0 ?
                        hashSetBodyNodes.get(specCor).toString() : hashSetBodyNodes.get(specCor).childNodes().get(0).toString();
                specCorStr= specCorStr.split("-").length!=3?specCorStr:"空";
                if (specCorStr.contains("<div")){
                    specCorStr="空";
                }
                pipiInfo.setSpec(specCorStr.trim());
                int originCor=hashMapTables.get("产地")<0?hashMapTables.get("产地"):hashMapTables.get("产地");
                String originCorStr = hashSetBodyNodes.get(originCor).toString();
                originCorStr= originCorStr.split("-").length!=3?originCorStr:"空";
                pipiInfo.setOrigin(originCorStr.trim());
                Node originCorNode = hashSetBodyNodes.get(originCor);
                String orginCorStr= (originCorNode.childNodes()!=null&&originCorNode.childNodes().size()!=0)?hashSetBodyNodes.get(originCor).childNode(0).toString():"空";
                pipiInfo.setOrigin(orginCorStr.trim());
                pipiInfos.add(pipiInfo);
            }
        }
        return pipiInfos;
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
