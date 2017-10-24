package com.study.www.service;

import com.study.www.entity.PipiUpDownEntity;
import com.study.www.entity.PipiUpDownExplain;
import com.study.www.utils.PipiUtils;
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
        Object pipisObj = resultItems.get(DzspProcessorService.KEY);
        if (pipisObj!=null){
            if (pipisObj instanceof Map){
                Map<String, Object> pipis=(Map<String, Object>)pipisObj;
                pipiService.savePipiData((List<PipiUpDownEntity>)pipis.get(PipiUtils.PIPIUPDOWNENTITY),(PipiUpDownExplain)pipis.get(PipiUtils.PIPIUPDOWNEXPLAIN));
            }
        }
    }
}
