package com.springcloud.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 配置 WebSecurityConfigurerAdapter
 */
@EnableWebSecurity  //开启WebSecurity功能
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启方法级别的认证保护
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 做了Spring Security 的基本配置，并通过AuthenticationManagerBuilder 在内存中创建了一个认证用户的信息，该认证用户名为admin，密码为123456，有USER角色。
     * 上述的代码内容虽少，但做了很多安全防护的工作，包括如下内容：
     * <ol>
     *     <li/>应用的每一个请求都需要认证。
     *     <li/>自动生成了一个登录表单。
     *     <li/>可以用usemame 和password 来进行认证。
     *     <li/>用户可以注销。
     *     <li/>阻止了CSRF 攻击。
     *     <li/>Session Fixation 保护。
     *     <li>
     *         安全Hea der 集成了以下内容。
     *         <ul>
     *             <li/>HTTP Strict Transport Sec旧ity for secure requests
     *             <li/>X-Content-Type-Options integration
     *             <li/>Cache Control
     *             <li/>X-XSS-Protection integration
     *             <li/>XFrame-Options integration to help prevent Clickjacking
     *         </ul>
     *     </li>
     *     <li>
     *         集成了以下的ServletAPI 的方法。
     *         <ul>
     *             <li/>HttpServletRequest#getRemoteUser()
     *             <li/>HttpServletRequest.html # getUserPrincipal()
     *             <li/>HttpServletRequest.html# isUserlnRoleGava.lar .String )
     *             <li/>HttpServletRequest.html#loginGava.lang.String, java.lang.String)
     *             <li/>HttpServletRequest.html # logout()
     *         </ul>
     *     </li>
     * </ol>
     *
     */
    //参数注入 AuthenticationManagerBuilder
    public void configureGlobal(@Autowired AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("USER");//直接在内存中创建用户

//        auth.userDetailsService(userDetailsService());//从内存中读取用户数据

        auth.userDetailsService(userDetailsService);//从数据库中读取用户数据
    }


    /**
     * 在内存中创建用户
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("jls").password("123456").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("123456").roles("USER", "ADMIN").build());

        return manager;
    }
}
