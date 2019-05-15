/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.gam.siev;

///**
// *
// * @author VI8G023
// */
//import javax.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaDialect;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableJpaRepositories(value = {"com.telcel.gam.siev.modelo"})
//@EnableTransactionManagement
//@EnableAutoConfiguration
//@ComponentScan("com.telcel.gam.siev.modelo")
//@PropertySource("classpath:application.properties")
public class JpaConfig {
//    @Autowired
//    private Environment environment;
//
//    @Bean
//    public DataSource dataSource() {
//            DriverManagerDataSource dataSource = new DriverManagerDataSource();
//            dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
//            dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
//            dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
//            dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
//            return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        vendorAdapter.setShowSql(true);
//
//        
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        JpaDialect jpaDialect = new HibernateJpaDialect();
//        factory.setJpaDialect(jpaDialect);
//        factory.setPackagesToScan("com.telcel.gam.siev.modelo");
//        factory.setDataSource(dataSource());
//        return factory;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory);
//        return txManager;
//    }       
}
