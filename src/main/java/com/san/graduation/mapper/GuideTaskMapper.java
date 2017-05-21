package com.san.graduation.mapper;

import com.san.graduation.common.mybatis.CommonMapper;
import com.san.graduation.domain.GuideTask;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *学霸发帖表
 */
public interface GuideTaskMapper extends CommonMapper<GuideTask> {
    List<GuideTask> findByKeyWord(@Param("keyWord") String keyWord);
}