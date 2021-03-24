package com.springcloud.springbootsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法级别的认证保护
public class HttpSecurity extends WebSecurityConfigurerAdapter {

    /**
     * WebSecurityConfigurerAdapter 配置了如何验证用户信息。那么Spring Security 如何知道是否所有的用户都需要身份验证呢？
     * 又如何知道要支持基于表单的身份验证呢？ 工程的哪些资源需要验证， 哪些资源不需要验证？这时就需要配置HttpSecurity</br>
     *
     * 这里主要是对资源的访问设置了认证
     */
    @Override
    protected void configure(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/index").permitAll()//不需验证资源
                .antMatchers("/user/**").hasRole("USER")//需要用户角色是USER才能访问的资源
                .antMatchers("/blogs/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")//登录地址/login 登录失败地址/login-error
                .and()
                .exceptionHandling().accessDeniedPage("/401");//异常处理重定向至/401

        http.logout().logoutSuccessUrl("/");//logout成功退回至首页
    }
}
