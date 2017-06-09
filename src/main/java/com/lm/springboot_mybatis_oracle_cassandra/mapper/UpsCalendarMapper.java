package com.lm.springboot_mybatis_oracle_cassandra.mapper;

import java.util.List;

import com.lm.springboot_mybatis_oracle_cassandra.entity.UpsCalendarEntity;

/**
 * oracel数据库mapper层
 * @author liangming.deng
 * @date   2017年6月9日
 *
 */
public interface UpsCalendarMapper {
	public List<UpsCalendarEntity> getAll();
	/**
	 * 删除
	 * 
	 * @
	 */
	public void delete() ;

	/**
	 * 批量新增
	 * 
	 * @param list
	 * @
	 */
	public void batchInsert(List<UpsCalendarEntity> list) ;
}