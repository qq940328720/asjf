package com.aishang.asjf.assembly.config.security;


import com.aishang.asjf.assembly.config.security.handler.RestAccessDeniedHandler;
import com.aishang.asjf.assembly.config.security.handler.RestAuthenticationEntryPoint;
import com.aishang.asjf.assembly.config.security.handler.RestAuthenticationFailureHandler;
import com.aishang.asjf.assembly.config.security.handler.RestAuthenticationSuccessHandler;
import com.aishang.asjf.assembly.config.security.jwt.filter.JwtAuthenticationFilter;
import com.aishang.asjf.assembly.config.security.jwt.provider.EmplAuthenticationProvider;
import com.aishang.asjf.assembly.config.security.jwt.provider.JwtAuthenticationProvider;
import com.aishang.asjf.common.enums.UserType;
import com.aishang.asjf.facade.service.ICustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by neeke on 17-9-11.
 * Spring Security配置类
 */
@EnableWebSecurity
@ComponentScan
//@PropertySource("classpath:org/springframework/security/messages_zh_CN.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;

//    @Autowired
//    @Qualifier("myUserDetailsService")
//    private UserDetailsService userDetailsService;

    @Autowired
    private ICustService custService;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;

    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;

    /**
     * 接口访问权限规则
     */
    @Value("${security.accessExpressions}")
    private String accessExpressions;
    @Value("${security.accessExpressions4cust}")
    private String accessExpressions4cust;
    @Value("${security.accessExpressions4empl}")
    private String accessExpressions4empl;

    /**
     * 配置身份认证器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //员工
        auth.authenticationProvider(emplAuthenticationProvider());
        //客户
        auth.authenticationProvider(jwtAuthenticationProvider).userDetailsService(custService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public EmplAuthenticationProvider emplAuthenticationProvider() {
        return new EmplAuthenticationProvider();
    }

    /**
     * 密码加密器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    @Bean
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }

    /**
     * jwt认证过滤器
     *
     * @return
     * @throws Exception
     */
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter();
    }
//
//    @Bean
//    public MessageSourceAccessor messageSourceAccessor() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:org/springframework/security/messages_zh_CN");
//        messageSource.setDefaultEncoding("UTF-8");
//        return new MessageSourceAccessor(messageSource, Locale.CHINESE);
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests().antMatchers("/**").permitAll();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//        http.addFilter(jwtAuthenticationFilter());
        http
                .cors().and()
                .apply(new RestLoginConfigurer<>())
                .loginProcessingUrl("/auth")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .and().logout().logoutUrl("/logout")
                .and()
                .csrf().disable().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .accessDeniedHandler(restAccessDeniedHandler)
                .and().authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .antMatchers("/auth/**").permitAll()
                .antMatchers(
                        "/auth/**",
                        "/logout/**",
                        "/cust/reg/**",
                        "/cust/password/**",
                        "/favicon.ico",
                        "/resources/**",
                        "/**/*.html",
                        "/swagger/**",
                        "/druid/**",
                        "/logback/**",
                        "/webjars/**",
                        "/outer/**",
                        "/sms/**",
                        "/swagger-resources/**").permitAll()
                .antMatchers("/" + UserType.CUSTOMER.getValue() + "/**").access(accessExpressions4cust)
                .antMatchers("/" + UserType.EMPLOYEE.getValue() + "/**").access(accessExpressions4empl)
                .anyRequest().access(accessExpressions)
//                .anyRequest().permitAll()
                .and()
                .headers().cacheControl().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}
