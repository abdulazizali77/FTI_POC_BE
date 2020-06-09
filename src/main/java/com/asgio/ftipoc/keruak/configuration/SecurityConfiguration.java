package com.asgio.ftipoc.keruak.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("password").roles("USER", "ADMIN").build();
        UserDetails user3 = User.withDefaultPasswordEncoder().username("poop").password("doop").roles("USER", "MEH").build();
        return new InMemoryUserDetailsManager(user, user2, user3);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
                //registry.addMapping("/*").allowedOrigins("*");
            }
        };
    }
}
