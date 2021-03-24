package com.example.springcloud.springbootadmin.adminserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();//设置登录界面,且访问时不需要认证
        http.logout().logoutUrl("/logout");//设置登出界面
        http.csrf().disable();//禁止csrf-跨站请求伪造
        http.authorizeRequests().antMatchers("/login.html", "/**/**.css", "/img/**", "/third-party/**").permitAll();//访问时不需认证资源
        http.authorizeRequests().antMatchers("/**").authenticated();//访问时需认证资源
        http.httpBasic();//开启http基本认证
    }
}
