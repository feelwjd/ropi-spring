package com.ropi.ropispring.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "com.ropi.ropispring.DAO6", sqlSessionFactoryRef = "ropi6SqlSessionFactory")
public class DatabaseRopi6Config {
	@Bean(name="ropi6DataSource")
	@ConfigurationProperties(prefix = "spring.ropi6.datasource")
	public DataSource ropi1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="ropi6SqlSessionFactory")
	public SqlSessionFactory ropi1SqlSessionFactory(@Qualifier("ropi6DataSource") DataSource ropi6DataSource, ApplicationContext applicationContext)throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ropi6DataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/ropi6/*.xml"));
        return sqlSessionFactoryBean.getObject();
	}
	
	 @Bean(name ="ropi6SqlSessionTemplate")
	    public SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory ropi6DataSource)throws Exception {
	        return new SqlSessionTemplate(ropi6DataSource);
	    }
}
