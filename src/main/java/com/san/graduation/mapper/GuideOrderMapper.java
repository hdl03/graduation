package com.san.graduation.mapper;

import com.san.graduation.common.mybatis.CommonMapper;
import com.san.graduation.domain.GuideOrder;
import com.san.graduation.dto.GuideOrderMapDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *学霸订单表
 */
public interface GuideOrderMapper extends CommonMapper<GuideOrder> {

    //查看我的学霸贴
    public List<GuideOrderMapDto> findBySendNo(@Param("sendNo") String sendNo);

    //findByRecevierNo
    //查看w我的接受学霸贴r
    public List<GuideOrderMapDto> findByRecevierNo(@Param("recevierNo") String recevierNo);


}