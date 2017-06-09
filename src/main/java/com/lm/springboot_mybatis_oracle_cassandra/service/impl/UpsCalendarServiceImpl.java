package com.lm.springboot_mybatis_oracle_cassandra.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.springboot_mybatis_oracle_cassandra.dao.UpsCalendarCassandraDao;
import com.lm.springboot_mybatis_oracle_cassandra.entity.UpsCalendarEntity;
import com.lm.springboot_mybatis_oracle_cassandra.mapper.UpsCalendarMapper;
import com.lm.springboot_mybatis_oracle_cassandra.service.UpsCalendarService;

@Service
public class UpsCalendarServiceImpl implements UpsCalendarService {

	private static Logger logger = LoggerFactory.getLogger(UpsCalendarServiceImpl.class);

	@Autowired
	private UpsCalendarCassandraDao UpsCalendarCassandraDao;

	@Autowired
	private UpsCalendarMapper UpsCalendarMapper;

	@Override
	public void batchSaveCassandraToOracle() {
		List<UpsCalendarEntity> UpsCalendars = null;
		// 1.获取cassandra数据
		UpsCalendars = UpsCalendarCassandraDao.getAll();
		// 2.删除oracle数据
		UpsCalendarMapper.delete();
		// 3.批量增加oracle数据
		UpsCalendarMapper.batchInsert(UpsCalendars);

		logger.info("batchSaveCassandraToOracle finish");
	}

	@Override
	public void batchSaveExceptionCassandraToOracle() {
		List<UpsCalendarEntity> UpsCalendars = null;
		// 1.获取cassandra数据
		UpsCalendars = UpsCalendarCassandraDao.getAll();
		// 2.删除oracle数据
		UpsCalendarMapper.delete();
		//手动给出异常
		int j = 1 / 0;
		// 3.批量增加oracle数据
		UpsCalendarMapper.batchInsert(UpsCalendars);

		logger.info("batchSaveCassandraToOracle finish");
	}

}
