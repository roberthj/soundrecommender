//package com.roberthj.soundrecommender.config;
//
//
//import org.jooq.DSLContext;
//import org.jooq.SQLDialect;
//import org.jooq.impl.DSL;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.TransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DbConfig {
//
//    @Bean
//    public DataSource soundRecommenderDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres");
//
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(soundRecommenderDataSource());
//    }
//
//    @Bean
//    public TransactionManager transactionManager() {
//        return new DataSourceTransactionManager(soundRecommenderDataSource());
//    }
//
//    @Bean
//    public DSLContext getDslContext(){
//        DSLContext dslContext = DSL.using(soundRecommenderDataSource(), SQLDialect.POSTGRES);
//
//        return dslContext;
//    }
//
//}
