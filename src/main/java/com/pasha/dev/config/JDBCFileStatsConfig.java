package com.pasha.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JDBCFileStatsConfig {

              @Bean
              public JdbcTemplate getJdbcTemplate(){
                  return new JdbcTemplate(getDataSource());
              }

              @Bean
              public DataSource getDataSource()
              {
                  DriverManagerDataSource dataSource = new DriverManagerDataSource();
                  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
                  dataSource.setUrl("jdbc:mysql://localhost:3306/myschema?useSSL=false");
                  dataSource.setUsername("topprogereu");
                  dataSource.setPassword("Pasha1997");

                  return dataSource;
              }

}
