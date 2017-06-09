package com.lm.springboot_mybatis_oracle_cassandra.dao;

import java.util.List;

import com.lm.springboot_mybatis_oracle_cassandra.entity.UpsCalendarEntity;

/**
 * 
 * @author liangming.deng
 * @date   2017年6月9日
 *
 */
public interface UpsCalendarCassandraDao {
	public List<UpsCalendarEntity> getAll();
}