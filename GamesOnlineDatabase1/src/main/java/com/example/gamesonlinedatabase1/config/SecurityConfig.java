package com.example.gamesonlinedatabase1.config;

import com.example.gamesonlinedatabase1.Service.MyuserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyuserDetailsService myuserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder user) throws Exception {
        user.userDetailsService(myuserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/Api/v1/use/Register/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/games").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/games/add").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/games/delegame").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/games/updategame").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/games/gametype").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
