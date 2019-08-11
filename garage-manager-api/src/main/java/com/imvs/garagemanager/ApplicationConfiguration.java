package com.imvs.garagemanager;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(ignoreResourceNotFound = false, value = "classpath:application.properties")
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class ApplicationConfiguration extends SpringBootServletInitializer {
	
	@Value("${user.timezone:GMT-3}")
	private String userTimeZone;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }
 
    @PostConstruct
	public void started() {
		TimeZone.setDefault(TimeZone.getTimeZone(userTimeZone));
	}

	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
		return builder.sources(ApplicationConfiguration.class).bannerMode(Banner.Mode.CONSOLE);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return configureApplication(builder);
	}
}
