package com.san.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.san.graduation.common.UserContext;
import com.san.graduation.common.util.Logger;
import com.san.graduation.dto.GuideOrderDto;
import com.san.graduation.dto.GuideOrderMapDto;
import com.san.graduation.dto.GuideTaskDto;
import com.san.graduation.mapper.GuideOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017\5\28 0028.
 * <p>
 * 学霸订单表操作
 */
@Service
public class GuideOrderService {
    @Autowired
    private GuideOrderMapper guideOrderMapper;


    /**
     * 我的学霸订单 分页查询
     */

    public PageInfo gainMyGuideOrder(Integer pageNum, Integer pageSize, Boolean isRecevierNo) {
        Logger.info(this, "gain myGuideOrder");
        // 获取当前用户编号
        String sendNo = UserContext.getCurrentUserNo().get();

        List<GuideOrderMapDto> mapDtos = null;
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 是接受的帖子
        if (isRecevierNo) {
            // 根据用户编号查询接受的帖子
            mapDtos = guideOrderMapper.findByRecevierNo(sendNo);
        } else {
            // 根据户编号查询发出的帖子
            mapDtos = guideOrderMapper.findBySendNo(sendNo);
        }


        //PageInfo info = new PageInfo();
        Logger.debug(this, "findBySendNo" + mapDtos);

        PageInfo info = new PageInfo(mapDtos);


        // 分页参数封装
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(info, pageInfo);

        //封装
        List<GuideTaskDto> taskDtos = mapDtos.stream().map((mapDto) -> {
            // 帖子
            GuideTaskDto taskDto = new GuideTaskDto();
            BeanUtils.copyProperties(mapDto.getGuideTask(), taskDto);
            // 订单
            GuideOrderDto order = new GuideOrderDto();
            BeanUtils.copyProperties(mapDto, order);
            taskDto.setGuideOrderDto(order);
            return taskDto;

        }).collect(Collectors.toList());

        pageInfo.setList(taskDtos);

        return pageInfo;
    }

}
