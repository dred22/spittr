package spittr.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"spittr"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@PropertySource("classpath:application.properties")
public class RootConfig {
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
                return new PropertySourcesPlaceholderConfigurer();
        }
        @Bean
        public ModelMapper modelMapper() {
                return new ModelMapper();
        }
}