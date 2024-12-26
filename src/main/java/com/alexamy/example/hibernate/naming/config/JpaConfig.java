package com.alexamy.example.hibernate.naming.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
//@EnableJpaRepositories(basePackages = "com.alexamy.example.hibernate.naming.domain.repository"
//        , entityManagerFactoryRef = JpaConfig.ENTITY_MANAGER_FACTORY
//        , transactionManagerRef = JpaConfig.TRANSACTION_MANAGER)
//@EnableTransactionManagement(proxyTargetClass = true)
@Slf4j
public class JpaConfig {

    public static final String ENTITY_MANAGER_FACTORY = "booksEntityManagerFactory";
    public static final String TRANSACTION_MANAGER = "booksTransactionManager";

    @Bean(ENTITY_MANAGER_FACTORY)
    @Primary
    public LocalContainerEntityManagerFactoryBean booksEntityManagerFactory(
//            CamelCaseToUnderscoresNamingStrategy customSchemaNamePhysicalNamingStrategy,
            DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.alexamy.example.hibernate.naming.domain.model");
//        factory.getJpaPropertyMap().put("hibernate.physical_naming_strategy", customSchemaNamePhysicalNamingStrategy);
        return factory;
    }

    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager(
            @Qualifier(ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
