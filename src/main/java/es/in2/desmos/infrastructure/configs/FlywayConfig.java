package es.in2.desmos.infrastructure.configs;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({R2dbcProperties.class, FlywayProperties.class})
class FlywayConfig {

    @Bean(initMethod = "migrate")
    public Flyway flyway(FlywayProperties flywayProperties, R2dbcProperties r2dbcProperties) {
        return Flyway.configure()
                .dataSource(flywayProperties.getUrl(), r2dbcProperties.getUsername(), r2dbcProperties.getPassword())
                .locations(flywayProperties.getLocations().toArray(String[]::new))
                .defaultSchema("desmos")
                .baselineOnMigrate(true)
                .load();
    }

}
