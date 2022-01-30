package com.rmarrugo.survey.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@EnableJpaRepositories(
        basePackages = "com.rmarrugo.survey.persistence",
        entityManagerFactoryRef = "persistenceEntityManager"
)
@Configuration
public class JpaEntityConfig {

    @Bean(name = "persistenceDataSource")
    public DataSource ecncDataSource(Environment env) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("persistence.jdbc.driverClassName"),
                "Configure [persistence.jdbc] placeholders"));
        dataSource.setUrl(env.getProperty("persistence.jdbc.url"));
        dataSource.setUsername(env.getProperty("persistence.jdbc.user"));
        dataSource.setPassword(env.getProperty("persistence.jdbc.pass"));
        return dataSource;
    }

    @Bean(name = "persistenceEntityManager")
    public LocalContainerEntityManagerFactoryBean persistenceEntityManager(@Qualifier("persistenceDataSource") DataSource persistenceDataSource,
                                                                           Environment env) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(persistenceDataSource);
        em.setPackagesToScan("com.rmarrugo.survey.persistence.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("persistence.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("persistence.hibernate.hbm2ddl.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }


}
