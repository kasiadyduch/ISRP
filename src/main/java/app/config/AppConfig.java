package app.config;

import app.web.CorsFilter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.Filter;

/**
 * Created by Karolina on 29.11.2017.
 */
@EnableTransactionManagement
@Configuration
public class AppConfig extends WebMvcAutoConfiguration {
    @Bean
    public Filter corsConfigurer() {
        return new CorsFilter();
    }
}
