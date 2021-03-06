package com.cauc.devManage;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AccessAllowedFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		if ("OPTIONS".equals(request.getMethod())) {
			String allowHeaders = request.getHeader("Access-Control-Allow-Headers");
			if(allowHeaders != null) {
				response.addHeader("Access-Control-Allow-Headers", allowHeaders);
			} else {
				response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
			}
            
        } else {
            chain.doFilter(request, response);
        }
	}
}
