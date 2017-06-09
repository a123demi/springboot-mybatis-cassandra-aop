package com.lm.springboot_mybatis_oracle_cassandra.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 主数据源配置(可配多数据源)
 * 
 * @author liangming.deng
 * @date 2017年6月9日
 *
 */
@Configuration
@MapperScan(basePackages = "com.lm.springboot_mybatis_oracle_cassandra.mapper", sqlSessionTemplateRef = "primarySqlSessionTemplate")
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "primarySqlSessionFactory")
	public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "primaryTransactionManager")
	public DataSourceTransactionManager primaryTransactionManager(
			@Qualifier("primaryDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "primarySqlSessionTemplate")
	public SqlSessionTemplate primarySqlSessionTemplate(
			@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}