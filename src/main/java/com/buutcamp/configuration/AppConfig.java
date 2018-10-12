package com.buutcamp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.buutcamp")
@PropertySource("classpath:countries.properties")
public class AppConfig {
}
