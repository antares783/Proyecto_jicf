package com.telcel.gam.siev.configuration;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.faces.webapp.FacesServlet;
import javax.persistence.EntityManagerFactory;
import javax.servlet.DispatcherType;
import javax.sql.DataSource;

import java.util.EnumSet;

@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EnableTransactionManagement
@EnableJpaRepositories(value = {"com.telcel.gam.siev.modelo"})
@ComponentScan({"com.telcel.gam.siev.configuration","com.telcel.gam.siev.controller"})
//,"com.telcel.gam.siev.controller"
@PropertySource("classpath:application.properties")
public class Application extends SpringBootServletInitializer {
	
	@Autowired
    private Environment environment;
	
    public static void main(String[] args) {	
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean<FacesServlet>(servlet, "*.xhtml");
    }
    
    @Bean
    public FilterRegistrationBean<RewriteFilter> rewriteFilter() {
        FilterRegistrationBean<RewriteFilter> rwFilter = new FilterRegistrationBean<RewriteFilter>(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }
    
    @Bean
    public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
            dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
            dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
            dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
            return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        JpaDialect jpaDialect = new HibernateJpaDialect();
        factory.setJpaDialect(jpaDialect);
        factory.setPackagesToScan("com.telcel.gam.siev.modelo");
        factory.setDataSource(dataSource());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }  
}
