package com.lm.springboot_mybatis_oracle_cassandra.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import com.lm.springboot_mybatis_oracle_cassandra.dao.UpsCalendarCassandraDao;
import com.lm.springboot_mybatis_oracle_cassandra.entity.UpsCalendarEntity;

/**
 * 获取cassandra数据库数据dao实现
 * @author liangming.deng
 * @date   2017年6月9日
 *
 */
@Repository
public class UpsCalendarCassandraDaoImpl implements UpsCalendarCassandraDao {
	@Autowired
	private CassandraTemplate cassandraTemplate;

	@Override
	public List<UpsCalendarEntity> getAll() {
		return cassandraTemplate.select(
				"SELECT  ID, NAME, DESCRIPTION, ORG_ID, IS_ACTIVE, CREATED, CREATEDBY, UPDATED,UPDATEDBY FROM UPS_CALENDAR",
				UpsCalendarEntity.class);
	}
}
