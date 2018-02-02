package ru.mail.kovgantatyana.config;

import org.springframework.context.annotation.*;
import ru.mail.kovgantatyana.config.hibernate.HibernateConfig;
import ru.mail.kovgantatyana.config.security.SecurityConfig;
import ru.mail.kovgantatyana.config.web.WebConfig;

@Configuration
@Import({HibernateConfig.class, WebConfig.class, SecurityConfig.class})
@EnableAspectJAutoProxy
@PropertySource(value = {"classpath:properties/hibernate.properties"})
public class AppConfig {
}
