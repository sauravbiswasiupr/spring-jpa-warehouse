package saurav.springjpa.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by saurav on 12/31/16.
 */
@Configuration
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("saurav.springjpa.resources");
    }
}
