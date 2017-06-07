package com.san.graduation.mapper;

import com.san.graduation.common.mybatis.CommonMapper;
import com.san.graduation.domain.HelpOrder;
import com.san.graduation.dto.HelpOrderMapDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 学渣订单表
 *
 */
public interface HelpOrderMapper extends CommonMapper<HelpOrder> {
    //查看我的学渣贴
    public List<HelpOrderMapDto> findBySendNo(@Param("sendNo") String sendNo);

    //findByRecevierNo
    //查看w我的接受学渣贴r
    public List<HelpOrderMapDto> findByRecevierNo(@Param("recevierNo") String recevierNo);
}