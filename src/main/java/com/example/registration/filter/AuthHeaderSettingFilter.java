package com.example.registration.filter;

import org.apache.commons.lang3.StringUtils;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper; import java.io.IOException;



@WebFilter
public class AuthHeaderSettingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequestWrapper requestWrapper = new 
        HttpServletRequestWrapper((HttpServletRequest) request) {
            /**
            * 当调用request.getHeader("token")时，则获取请求参数中token值并当做Header的值返回 * @param name
            * @return
            */
            @Override
            public String getHeader(String name) {
                // 先从原本的Request中获取头，如果为空且名字为token，则从参数中查找并返回
                String superHeader = super.getHeader(name);
                if("Authorization".equals(name)&&StringUtils.isEmpty(superHeader)){
                    String token = request.getParameter("token"); 
                    if (StringUtils.isNotEmpty(token)) {
                        return token ; 
                    }
                }
                return superHeader; 
            }
        };
        System.out.println("执行了过滤器");
        chain.doFilter(requestWrapper,response); 
    }

    @Override
    public void destroy() { }
}
