package com.san.graduation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.san.graduation.common.UserContext;
import com.san.graduation.common.util.Logger;
import com.san.graduation.domain.GuideOrder;
import com.san.graduation.dto.GuideOrderDto;
import com.san.graduation.dto.GuideTaskDto;
import com.san.graduation.dto.GuideTaskMapDto;
import com.san.graduation.mapper.GuideOrderMapper;
import com.san.graduation.mapper.GuideTaskMapper;
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
    private GuideTaskMapper guideTaskMapper;


    /**
     * 我的学霸订单 分页查询
     */

    public PageInfo gainMyGuideOrder(Integer pageNum, Integer pageSize) {
        Logger.info(this, "gain myGuideOrder");
        PageHelper.startPage(pageNum, pageSize);
        //TODO 需要判断是否登录
        String sendNo = UserContext.getCurrentUserNo().get();
        List<GuideTaskMapDto> mapDtos = guideTaskMapper.findBySendNo(sendNo);
        //PageInfo info = new PageInfo();
        Logger.debug(this, "findBySendNo" + mapDtos);

        PageInfo info = new PageInfo(mapDtos);
        //封装
       List<GuideTaskDto> taskDtos =  mapDtos.stream().map((mapDto) -> {

            GuideTaskDto taskDto = new GuideTaskDto();
            BeanUtils.copyProperties(mapDto, taskDto);

            List<GuideOrderDto> guideOrderDtos = mapDto.getGuideOrders().stream().map((dto) -> {

                GuideOrderDto order = new GuideOrderDto();
                BeanUtils.copyProperties(dto, order);
                return order;
            }).collect(Collectors.toList());
            taskDto.setGuideOrderDtos(guideOrderDtos);

            return taskDto;
        }).collect(Collectors.toList());


        PageInfo pageInfo = new PageInfo(taskDtos);
        BeanUtils.copyProperties(info,pageInfo);

        return pageInfo;
    }

}
