package com.san.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.san.graduation.common.UserContext;
import com.san.graduation.common.util.Logger;
import com.san.graduation.dto.*;
import com.san.graduation.mapper.HelpOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shanlin on 2017/6/7.
 */
@Service
public class HelpOrderService {
    @Autowired
    private HelpOrderMapper helpOrderMapper;


    /**
     * 我的学渣订单 分页查询
     */

    public PageInfo gainMyHelpOrder(Integer pageNum, Integer pageSize, Boolean isRecevierNo) {
        Logger.info(this, "gain myGuideOrder");
        // 获取当前用户编号
        String sendNo = UserContext.getCurrentUserNo().get();

        List<HelpOrderMapDto> mapDtos = null;
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 是接受的帖子
        if (isRecevierNo) {
            // 根据用户编号查询接受的帖子
            mapDtos = helpOrderMapper.findByRecevierNo(sendNo);
        } else {
            // 根据户编号查询发出的帖子
            mapDtos = helpOrderMapper.findBySendNo(sendNo);
        }


        //PageInfo info = new PageInfo();
        Logger.debug(this, "findBySendNo" + mapDtos);

        PageInfo info = new PageInfo(mapDtos);


        // 分页参数封装
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(info, pageInfo);

        //封装
        List<HelpTaskDto> taskDtos = mapDtos.stream().map((mapDto) -> {
            // 帖子
            HelpTaskDto taskDto = new HelpTaskDto();
            BeanUtils.copyProperties(mapDto.getHelpTask(), taskDto);
            // 订单
            HelpOrderDto order = new HelpOrderDto();
            BeanUtils.copyProperties(mapDto, order);
            taskDto.setHelpOrderDto(order);
            return taskDto;

        }).collect(Collectors.toList());

        pageInfo.setList(taskDtos);

        return pageInfo;
    }

}
