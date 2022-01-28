package com.ropi.ropispring.config.database;

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
@MapperScan(basePackages = "com.ropi.ropispring.DAO7", sqlSessionFactoryRef = "ropi7SqlSessionFactory")
public class DatabaseRopi7Config {
	@Bean(name="ropi7DataSource")
	@ConfigurationProperties(prefix = "spring.ropi7.datasource")
	public DataSource ropi1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="ropi7SqlSessionFactory")
	public SqlSessionFactory ropi1SqlSessionFactory(@Qualifier("ropi7DataSource") DataSource ropi7DataSource, ApplicationContext applicationContext)throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ropi7DataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/ropi7/*.xml"));
        return sqlSessionFactoryBean.getObject();
	}
	
	 @Bean(name ="ropi7SqlSessionTemplate")
	    public SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory ropi7DataSource)throws Exception {
	        return new SqlSessionTemplate(ropi7DataSource);
	    }
}
