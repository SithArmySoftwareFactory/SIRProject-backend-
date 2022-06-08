package com.sith.sir.security;

import com.sith.sir.domain.AppUser;
import com.sith.sir.domain.Role;
import com.sith.sir.filter.CustomAuthenticationFilter;
import com.sith.sir.filter.CustomAuthorizationFilter;
import com.sith.sir.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        //http.authorizeRequests()  works without chaining, either or will work
        http.csrf()
                .disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/api/login/**",
                        "/api/token/refresh/**",
                        "/api/send/**", "https://cors-everywhere.herokuapp.com/http://107.21.146.178/api/send/**")
                .permitAll()
                .antMatchers(GET, "/api/users/**")
                .hasAnyAuthority("ROLE_SUPER_ADMIN", "ROLE_ADMIN")

                .antMatchers(GET, "/api/incident/**")
                .hasAnyAuthority("ROLE_SUPER_ADMIN")

                .antMatchers(PATCH, "/api/incident/**")
                .hasAnyAuthority("ROLE_SUPER_ADMIN", "ROLE_ADMIN")

                .antMatchers(PUT, "/api/incident/**")
                .hasAnyAuthority("ROLE_SUPER_ADMIN", "ROLE_ADMIN")
                .antMatchers(POST, "/api/incident/**")
                .permitAll()
                //.hasAnyAuthority("ROLE_SUPER_ADMIN", "ROLE_ADMIN")

                .and().sessionManagement()
                .sessionCreationPolicy(STATELESS).and()
        .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
               http.addFilter(customAuthenticationFilter);
//        http.csrf().disable().cors()
//                .and().sessionManagement()
//                .sessionCreationPolicy(STATELESS);
//        http.authorizeRequests()
//                .antMatchers(
//                        "/api/login/**",
//                        "/api/token/refresh/**",
//                        "/api/send/**")
//                .permitAll();
//        http.authorizeRequests()     .antMatchers(GET, "/api/users/**").hasAnyAuthority("ROLE_SUPER_ADMIN", "ROLE_ADMIN");
//        http.authorizeRequests()     .antMatchers(GET, "/api/incident/**").hasAnyAuthority("ROLE_SUPER_ADMIN");
//        http.authorizeRequests()    .antMatchers(POST, "/api/user/save/**", "http://localhost:3000/supervisor")
//                .hasAnyAuthority("ROLE_ADMIN").anyRequest().authenticated();
//        http.addFilter(customAuthenticationFilter);
//        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
