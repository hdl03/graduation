package com.san.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.san.graduation.common.UserContext;
import com.san.graduation.common.util.Logger;
import com.san.graduation.common.util.UUIDUtils;
import com.san.graduation.domain.HelpTask;
import com.san.graduation.exception.ParamsException;
import com.san.graduation.mapper.HelpTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuzr on 2017/5/20.
 * 操作学霸贴
 */
@Service
public class HelpTaskService {
    @Autowired
    private HelpTaskMapper helpTaskMapper;

    public int insert(HelpTask task) {
        String title = task.getTaskTitle();
        if (title == null || title.equals("")) {
            Logger.error(this, "title不能为空");
            throw new ParamsException();
        }
        task.setTaskNo(UUIDUtils.getInstance().getUniqueId());
        return helpTaskMapper.insert(task);
    }

    public PageInfo<HelpTask> findByKeyWord(int startPage, int pageSize, String keyWord) {
        if (startPage < 0 || pageSize < 0) {
            Logger.error(this, "startPage和pageSize不能小于零");
            throw new ParamsException();
        }
        PageHelper.startPage(startPage, pageSize);
        PageInfo<HelpTask> pageInfo = new PageInfo<>(helpTaskMapper.findByKeyWord(keyWord));
        return pageInfo;
    }
}
