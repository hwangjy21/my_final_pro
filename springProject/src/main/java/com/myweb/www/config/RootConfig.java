
package com.myweb.www.config;

/*import java.io.IOException;*/

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
/*import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;*/



@Configuration
@MapperScan(basePackages = {"com.myweb.www.repository"})
@ComponentScan(basePackages = {"com.myweb.www.service","com.myweb.www.handler","com.myweb.www.exception"})
@EnableAspectJAutoProxy 
@EnableTransactionManagement
@EnableScheduling
/*
 * 나중에
 * @EnableScheduling
 * 
 * @EnableTransactionManagement
 */
public class RootConfig {
	//DB 설정
	// 전과 달라지 부분 log4jdbc-log4j2 사용
	//hikariCP 사용
	
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Bean
	public DataSource  dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		//log4jdbc-log4j2의 드라이버 클래스 url 사용
		/*
		 * hikariConfig.setDriverClassName("net.sf.log.log4jdbc.sql.jdbcapi.DriverSpy");
		 */
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");

		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/springdb");
		hikariConfig.setUsername("springuser");
		hikariConfig.setPassword("mysql");
		
	
		hikariConfig.setMaximumPoolSize(5); //최대 유휴 커넥션 개수
		
		hikariConfig.setMinimumIdle(5); // 최소 유휴 커넥션 개수 (반드시 같은 값으로 해줘야한다=>성능을 최적화하기 위해서)
		
		hikariConfig.setConnectionTestQuery("SELECT now()");  //test
		hikariConfig.setPoolName("springHikariCP");
		
		//config 추가 설정
		// cache 사용여부 설정 true
		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true"); 
		
		//mysql 드라이버가 연결당 cache statement의 수에 관한 설정 -> 보통 25 (250~500 사이 권장)
		
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250"); 
		
		//mysql connection 당 캐시할 pareoaredStatment 개수 지정 옵션 default 256
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "true");

		
		
		//mysql 서버에서 최신 이슈가 있을 경우 지원 받는 설정 server-side 지원 설정 true
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts","true"); //수정해야 함
		
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		return hikariDataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlFactoryBean = new SqlSessionFactoryBean();
		sqlFactoryBean.setDataSource(dataSource());
		sqlFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/*.xml"));//오류 확인
		
		sqlFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/MybatisConfig.xml"));
		
		return (SqlSessionFactory)sqlFactoryBean.getObject();
	}
	
	//트렌젝션메니저 빈 설정
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	

}