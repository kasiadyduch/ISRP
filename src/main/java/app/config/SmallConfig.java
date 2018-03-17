package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Karolina on 29.11.2017.
 */
@Configuration
@ImportResource("classpath:my-config/myconfig.xml")
public class SmallConfig {
}
