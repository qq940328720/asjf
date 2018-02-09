package com.aishang.asjf.assembly.config.security.jwt.provider;

import com.aishang.asjf.client.employee.EmplServerClient;
import com.aishang.asjf.common.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 员工登录身份认证器
 */
public class EmplAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private EmplServerClient emplServerClient;
    private Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    /**
     * 调用小雨点权限系统的验证账号密码接口，如果成功就返回一个默认的UserDetails对象，反之则抛出异常。
     *
     * @param username
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        String account = authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        boolean isOk = emplServerClient.check(username, md5PasswordEncoder.encodePassword(password, null));
        if (!isOk) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorityList = new ArrayList<>();
                authorityList.add(new SimpleGrantedAuthority(UserType.EMPLOYEE.name()));
                return authorityList;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
