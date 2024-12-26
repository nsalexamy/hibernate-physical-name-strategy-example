package com.alexamy.example.hibernate.naming.component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * CustomSchemaNaingStrategy
 *
 * see https://stackoverflow.com/questions/61760869/spring-jpa-providing-schema-name-dynamically
 *
 */
@Component
@Slf4j
public class PropertyPlaceholdersNamingStrategy extends CamelCaseToUnderscoresNamingStrategy implements ApplicationContextAware {

    private Environment environment;

    @PostConstruct
    public void init() {
        log.info("=====> CustomSchemaNaingStrategy - init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("=====> CustomSchemaNaingStrategy - setApplicationContext");
        this.environment = applicationContext.getEnvironment();
    }

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        log.info("=====> toPhysicalTableName - logicalName: {}", logicalName);
        return super.toPhysicalTableName(resolvePlaceholders(logicalName), jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        log.info("=====> toPhysicalSchemaName - logicalName: {}", logicalName);

//        if(logicalName == null) {
//            return null;
//        }
//
//        final var schemaName = super.toPhysicalSchemaName(new Identifier(
//                environment.resolvePlaceholders(logicalName.getText()), logicalName.isQuoted()), jdbcEnvironment);
//
//        log.info("=====> toPhysicalSchemaName - schemaName: {}", schemaName);
//        return schemaName;

        return super.toPhysicalSchemaName(resolvePlaceholders(logicalName), jdbcEnvironment);
    }

    private String resolvePlaceholders(String text) {
        return environment.resolvePlaceholders(text);
    }




    private Identifier resolvePlaceholders(Identifier identifier) {
        if(identifier == null) {
            return null;
        }

        var resolvedIdentifier = new Identifier(resolvePlaceholders(identifier.getText()), identifier.isQuoted());

        log.info("=====> resolvePlaceholders - identifier: {}, resolvedIdentifier: {}", identifier, resolvedIdentifier);

        return resolvedIdentifier;
    }
}
