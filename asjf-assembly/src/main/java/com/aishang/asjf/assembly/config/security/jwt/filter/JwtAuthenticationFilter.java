package com.aishang.asjf.assembly.config.security.jwt.filter;

import com.aishang.asjf.assembly.config.security.jwt.JwtAuthenticationToken;
import com.aishang.asjf.common.JwtTokenUtil;
import com.aishang.asjf.facade.service.ICustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt过滤器
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.head}")
    private String head;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ICustService custService;

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//
//        try {
//            HttpServletRequest request = (HttpServletRequest) servletRequest;
////            SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(request.getHeader(this.tokenHeader)));
//            UserDetails userDetails = loadUserDetails((HttpServletRequest) servletRequest);
//            SecurityContext securityContext = createSecurityContext(userDetails);
//            SecurityContextHolder.setContext(securityContext);
//
////            if (securityContext.getAuthentication() != null && securityContext.getAuthentication().isAuthenticated()) {
////                String userName = (String) securityContext.getAuthentication().getPrincipal();
//////                tokenUtils.addHeader((HttpServletResponse) servletResponse, userName);
////            }
//
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//        finally {
//            // Clear the context and free the thread local
//            SecurityContextHolder.clearContext();
//        }
//    }
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//
//            HttpServletRequest request = (HttpServletRequest) servletRequest;
//            String accessToken = request.getHeader(this.tokenHeader);
//            SecurityContext securityContext = SecurityContextHolder.getContext();
//            if (securityContext.getAuthentication() == null){
//                filterChain.doFilter(servletRequest, servletResponse);
//            }else {
//                if (accessToken != null && !"".equals(accessToken)) {
//                    SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(accessToken));
//                }
////        else {
////            throw new JwtTokenMissingException("未找到token");
////        }
//                filterChain.doFilter(servletRequest, servletResponse);
//            }
//
//    }

    /**
     * 检查accessToken是否存在，存在则构造JwtAuthenticationToken并交给Spring Security
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader(tokenHeader);
        if (token != null && !"".equals(token)) {
            SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(token));
        }
//        else {
//            throw new JwtTokenMissingException("未找到token");
//        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

//    private SecurityContext createSecurityContext(UserDetails userDetails)
//    {
//        if (userDetails != null) {
//
//            SecurityContextImpl securityContext = new SecurityContextImpl();
//            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
//                    null, userDetails.getAuthorities());
//            securityContext.setAuthentication(authentication);
//            return securityContext;
//
//        }
//        return SecurityContextHolder.createEmptyContext();
//    }

//    private UserDetails loadUserDetails(HttpServletRequest request) throws ServletException
//    {
//        String accessToken = request.getHeader(this.tokenHeader);
//        String userName = null;
//        if (null == accessToken){
//            return null;
//        }
////        try {
//            userName = jwtTokenUtil.getUsernameFromToken(accessToken);
////        }catch (Exception ex){
////            throw new ServletException(ex.getLocalizedMessage());
////        }
//
//        return userName != null ? custService.loadUserByUsername(userName) : null;
//    }
}
