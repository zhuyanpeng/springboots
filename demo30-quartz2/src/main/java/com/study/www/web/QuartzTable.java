package com.study.www.web;

import com.study.www.enums.ConfigEnum;
import com.study.www.model.Config;
import com.study.www.model.Result;
import com.study.www.model.mapper.ConfigRepository;
import com.study.www.service.QuartzTableService;
import org.quartz.CronScheduleBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: :
 * @date :Create in  2018/2/24- 11:14
 * @Version: V1.0
 * @Modified By:
 **/
@Controller
public class QuartzTable {

    private final Logger LOGGER=LoggerFactory.getLogger(this.getClass());

    @Autowired
    ConfigRepository configRepository;
    @Autowired
    QuartzTableService tableService;


    @GetMapping("/table")
    public String table(ModelMap map){
        List<Config> configs = configRepository.findAll();
        for (Config config : configs) {
            String message = ConfigEnum.findByMessage(config.getStatus());
            config.setStatus(message);
        }
        map.put("configs",configs);
        return "/table";
    }

    @PostMapping("/updateStatus")
    @ResponseBody
    public Result updateStatus(Long id, String status){
        Result result = new Result();
        result.setResult(false);
        try {
            tableService.update(id,status);
            result.setResult(true);
        } catch (Exception e) {
            result.setMsg(e.toString());
        }
        return result;
    }
    @PostMapping("/updateQuartz")
    @ResponseBody
    public Result updateQuartz(Long id, String cron){
        Result result = new Result();
        result.setResult(false);
        try {
            CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(cron);
        }catch (Exception e){
            result.setMsg("cron表达式有误！！");
            return result;
        }
        try {
            tableService.updateCron(id,cron);
            result.setResult(true);
        } catch (Exception e) {
            result.setMsg(e.toString());
        }
        return result;
    }


}
