package com.lm.springboot_mybatis_oracle_cassandra.service;

/**
 * 服务层
 * @author liangming.deng
 * @date   2017年6月9日
 *
 */
public interface UpsCalendarService {
	/**
	 * cassandra批量插入oracle
	 * 
	 */
	public void batchSaveCassandraToOracle();

	/**
	 * 异常cassandra批量插入oracle
	 * 
	 */
	public void batchSaveExceptionCassandraToOracle();
}
