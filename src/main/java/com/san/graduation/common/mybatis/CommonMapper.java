package com.san.graduation.common.mybatis;



import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * 封装mysqlMapper
 *
 * mapper 接口，都继承这个接口
 *
 * @param <T>
 */

public interface CommonMapper<T> extends Mapper<T>,MySqlMapper<T> {
	
}
