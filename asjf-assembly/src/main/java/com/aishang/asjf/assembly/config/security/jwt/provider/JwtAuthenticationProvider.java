package com.aishang.asjf.assembly.config.security.jwt.provider;


import com.aishang.asjf.assembly.config.security.jwt.JwtAuthenticationToken;
import com.aishang.asjf.assembly.config.security.jwt.exception.*;
import com.aishang.asjf.client.employee.EmplServerClient;
import com.aishang.asjf.common.JwtTokenUtil;
import com.aishang.asjf.facade.service.ICustService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by neeke on 17-9-15.
 * Jwt身份认证器
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ICustService custService;

    @Autowired
    private EmplServerClient emplServerClient;
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//
//    }
//
//    @Override
//    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
//        String token = (String) jwtAuthenticationToken.getCredentials();
//        return null;
//    }

    /**
     * 校验accessToken是否有效
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getCredentials();
        String account = null;
        String role = null;
        try {
            account = jwtTokenUtil.getUsernameFromToken(token);
            role = jwtTokenUtil.getUserTypeFromToken(token);
        } catch (RequiredTypeException e) {
            e.printStackTrace();
            throw new RestRequiredTypeException(e.getLocalizedMessage());
        } catch (PrematureJwtException e) {
            e.printStackTrace();
            throw new RestPrematureJwtException(e.getLocalizedMessage());
        } catch (MissingClaimException e) {
            throw new RestMissingClaimException(e.getLocalizedMessage());
        } catch (MalformedJwtException e) {
            throw new RestMalformedJwtException(e.getLocalizedMessage());
        } catch (ExpiredJwtException e) {
            throw new RestExpiredJwtException(e.getLocalizedMessage());
        } catch (SignatureException e) {
            throw new RestSignatureException(e.getLocalizedMessage());
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getLocalizedMessage());
        }
//        UserDetails userDetails = null;
//        userDetails = custService.loadUserByUsername(account);
//        userDetails = emplServerClient.check()

        String finalAccount = account;
        String finalRole = role;
        return new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorityList = new ArrayList<>();
                authorityList.add(new SimpleGrantedAuthority("ROLE_" + finalRole));
                return authorityList;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return finalAccount;
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return finalAccount;
            }
        };
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.equals(authentication);
    }
}
