package com.lm.springboot_mybatis_oracle_cassandra.task;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lm.springboot_mybatis_oracle_cassandra.service.UpsCalendarService;

@Component
@Lazy(value = false)
public class SyncTask {
	private static Logger LOGGER = LoggerFactory.getLogger(SyncTask.class);

	@Autowired
	private UpsCalendarService upsCalendarService;

	@PostConstruct
	@Scheduled(cron = "${syncTask.cron}")
	public void syncCassandraToOracle() {

		LOGGER.info("SyncTask syncCassandraToOracle start sync...");
		upsCalendarService.batchSaveCassandraToOracle();
		upsCalendarService.batchSaveExceptionCassandraToOracle();

		LOGGER.info("SyncTask syncCassandraToOracle end sync...");
	}
}
