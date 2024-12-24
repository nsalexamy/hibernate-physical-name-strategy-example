package com.alexamy.example.hibernate.naming.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * HibernateConfig
 *
 * @see https://docs.spring.io/spring-boot/how-to/data-access.html#howto.data-access.configure-hibernate-naming-strategy
 */
//@Configuration(proxyBeanMethods = false)
@Slf4j
public class HibernateConfig {

    private final Environment environment;

    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

//    @Bean
    public CamelCaseToUnderscoresNamingStrategy customCamelCaseToUnderscoresNamingStrategy() {

        log.info("=====> customSchemaNamePhysicalNamingStrategy");

        return new CamelCaseToUnderscoresNamingStrategy() {

            @Override
            public Identifier toPhysicalSchemaName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
                log.info("=====> toPhysicalSchemaName - logicalName: {}", logicalName);
                if(logicalName == null) {
                    return null;
                }

                final var schemaName = super.toPhysicalSchemaName(new Identifier(
                        environment.resolvePlaceholders(logicalName.getText()), logicalName.isQuoted()), jdbcEnvironment);

                log.info("=====> toPhysicalSchemaName - schemaName: {}", schemaName);
                return schemaName;

            }
        };
    }

}
