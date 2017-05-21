package com.san.graduation.mapper;

import com.san.graduation.common.mybatis.CommonMapper;
import com.san.graduation.domain.HelpTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * 学渣发帖表
 */

public interface HelpTaskMapper extends CommonMapper<HelpTask> {
    List<HelpTask> findByKeyWord(@Param("keyWord")String keyWord);
}