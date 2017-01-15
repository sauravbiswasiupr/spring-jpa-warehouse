package saurav.springjpa.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by saurav on 9/19/16.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"saurav.springjpa.models"})
@EnableJpaRepositories(basePackages = {"saurav.springjpa.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
