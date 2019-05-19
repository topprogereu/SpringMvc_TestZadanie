package com.pasha.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.pasha.dev.dao")
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
                  dataSource.setUrl("jdbc:mysql://localhost:3306/pasha_test_zad?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                  dataSource.setUsername("root");
                  dataSource.setPassword("12345678");

                  return dataSource;
              }

}
