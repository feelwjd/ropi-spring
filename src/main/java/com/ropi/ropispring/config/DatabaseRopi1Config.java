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
@MapperScan(basePackages = "com.ropi.ropispring.DAO", sqlSessionFactoryRef = "ropi1SqlSessionFactory")
public class DatabaseRopi1Config {
	@Bean(name="ropi1DataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.ropi1.datasource")
	public DataSource ropi1DataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="ropi1SqlSessionFactory")
	@Primary
	public SqlSessionFactory ropi1SqlSessionFactory(@Qualifier("ropi1DataSource") DataSource ropi1DataSource, ApplicationContext applicationContext)throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ropi1DataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name ="ropi1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory ropi1DataSource)throws Exception {
        return new SqlSessionTemplate(ropi1DataSource);
    }
}
