package com.lm.springboot_mybatis_oracle_cassandra.datasource;

import java.util.Calendar;

import javax.sql.DataSource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * aop事务控制
 * 
 * @author liangming.deng
 * @date 2017年6月9日
 *
 */
@Aspect
@Configuration
public class TranscationAop {

	private static Logger logger = LoggerFactory.getLogger(TranscationAop.class);
	@Autowired
	PlatformTransactionManager transactionManager;

	/**
	 * 注入dataSource
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public PlatformTransactionManager txManager(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * 定义事务扫描包
	 */
	@Pointcut("execution(* com.lm.springboot_mybatis_oracle_cassandra.service..*.*(..))")
	public void service() {
	}

	/**
	 * 环绕通知 事务
	 * 
	 * @param pjp
	 * @return
	 */
	@Around("service()")
	public Object tran(ProceedingJoinPoint pjp) {

		long startTimeLong = Calendar.getInstance().getTimeInMillis();
		TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		String classInfo = getClassInfo(pjp);
		try {
			pjp.proceed();
		} catch (Throwable throwable) {

			logger.error(classInfo + " 异常 事务回滚 :" + throwable.getMessage());

			transactionManager.rollback(transactionStatus);
			return null;
		}
		transactionManager.commit(transactionStatus);
		long endTimeLong = Calendar.getInstance().getTimeInMillis();
		logger.info(classInfo + " 事务提交成功,耗时:" + (endTimeLong - startTimeLong));

		return null;
	}

	/**
	 * 获取className和method
	 * 
	 * @param pjp
	 * @return
	 */
	private static String getClassInfo(ProceedingJoinPoint pjp) {
		StringBuilder sBuilder = new StringBuilder();
		if (null == pjp) {
			return sBuilder.toString();
		}

		sBuilder.append(pjp.getTarget().getClass().getSimpleName()).append(" ").append(pjp.getSignature().getName());
		return sBuilder.toString();
	}
}
