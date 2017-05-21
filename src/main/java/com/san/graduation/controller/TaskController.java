package com.san.graduation.controller;

import com.github.pagehelper.PageInfo;
import com.san.graduation.common.BaseResponse;
import com.san.graduation.common.util.Logger;
import com.san.graduation.controller.param.GuideTaskParam;
import com.san.graduation.controller.param.HelpTaskParam;
import com.san.graduation.controller.param.PageParam;
import com.san.graduation.controller.result.GuideTaskResult;
import com.san.graduation.controller.result.HelpTaskResult;
import com.san.graduation.domain.GuideTask;
import com.san.graduation.domain.HelpTask;
import com.san.graduation.dto.PageDto;
import com.san.graduation.service.impl.GuideTaskService;
import com.san.graduation.service.impl.HelpTaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzr on 2017/5/20.
 * 帖子controller
 */

@RestController
@RequestMapping("/")
public class TaskController {

    @Autowired
    private GuideTaskService guideTaskService;
    @Autowired
    private HelpTaskService helpTaskService;

    @RequestMapping(value = "publish/guide_task", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse publishGuideTask(@RequestBody GuideTaskParam param){
        Logger.info(this,"publish guide task：");
        GuideTask task = new GuideTask();
        BeanUtils.copyProperties(param,task);
        guideTaskService.insert(task);
        return GuideTaskResult.success();
    }

    @RequestMapping(value = "publish/help_task", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse publishHelpTask(@RequestBody HelpTaskParam param){
        Logger.info(this,"publish Help task：");
        HelpTask task = new HelpTask();
        BeanUtils.copyProperties(param,task);
        helpTaskService.insert(task);
        return HelpTaskResult.success();
    }

    @RequestMapping(value = "query/help_task", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse queryHelpTask(@RequestBody PageParam param){
        Logger.info(this,"query Help task：");
        PageInfo<HelpTask> rawTasks = helpTaskService.findByKeyWord(param.getStartPage(),param.getPageSize(),param.getKeyWord());
        List<HelpTaskResult.Task> tasks = new ArrayList<>();
        for(HelpTask rawTask:rawTasks.getList()){
            HelpTaskResult.Task task = new HelpTaskResult.Task();
            BeanUtils.copyProperties(rawTask,task);
            tasks.add(task);
        }
        Logger.debug(this,"tasks：" + rawTasks.getClass());
        HelpTaskResult result = HelpTaskResult.success();
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(rawTasks,pageDto);
        result.setTasks(tasks);
        result.setPageDto(pageDto);
        return result;
    }

    @RequestMapping(value = "query/guide_task", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse queryGuideTask(@RequestBody PageParam param){
        Logger.info(this,"query guide task：");
        PageInfo<GuideTask> rawTasks = guideTaskService.findByKeyWord(param.getStartPage(),param.getPageSize(),param.getKeyWord());
        List<GuideTaskResult.Task> tasks = new ArrayList<>();
        for(GuideTask rawTask:rawTasks.getList()){
            GuideTaskResult.Task task = new GuideTaskResult.Task();
            BeanUtils.copyProperties(rawTask,task);
            tasks.add(task);
        }
        Logger.debug(this,"tasks：" + rawTasks.getClass());
        GuideTaskResult result = GuideTaskResult.success();
        PageDto pageDto = new PageDto();
        BeanUtils.copyProperties(rawTasks,pageDto);
        result.setPageDto(pageDto);
        result.setTasks(tasks);
        return result;
    }
}
