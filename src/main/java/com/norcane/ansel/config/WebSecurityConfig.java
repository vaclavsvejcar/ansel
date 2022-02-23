package com.norcane.ansel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        // made static to break circular dependency (see https://stackoverflow.com/a/70265714)
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        // require all requests to be authenticated except for the resources
        http.authorizeRequests()
            .antMatchers("/jakarta.faces.resource/**")
            .permitAll().anyRequest().authenticated();

        // login
        http.formLogin().loginPage("/login.xhtml").permitAll()
            .failureUrl("/login.xhtml?error=true");

        // logout
        http.logout().logoutSuccessUrl("/login.xhtml");


        // disable CSRF
        http.csrf().disable();
         */

        http.authorizeRequests()
            .antMatchers("/secured/admin/**", "/secured/view/admin/**").access("hasRole('ROLE_SUPERUSER')")
            .antMatchers("/dashboard.xhtml").authenticated()
            .antMatchers("/index.xhtml", "/index.html", "/login.xhtml", "/javax.faces.resources/**").permitAll()
            .and()
            .formLogin().loginPage("/login.xhtml")
            .and()
            .logout().logoutSuccessUrl("/index.xhtml").invalidateHttpSession(true).deleteCookies("JSESSIONID")
            .and()
            .exceptionHandling().accessDeniedPage("/error.xhtml")
            .and()
            .csrf().disable();
    }
}
