package com.example.restoservapi.security.filter;


import com.example.restoservapi.security.Service.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.PrintWriter;

/******************************************************
 * Esta clase es usada para filtrar las peticiones
 * y autenticar a los usuarios basado en el API Key.
 ******************************************************/
public class AuthenticationFilter extends GenericFilterBean {

    /*************************************************************************
     * Este método es usado para filtrar las peticiones y autenticar a los usuarios
     * basado en el API Key.
     * @param request: ServletRequest
     * @param response: ServletResponse
     * @param filterChain: FilterChain
     * @throws IOException
     * @throws ServletException
     *************************************************************************/
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception exp) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter writer = httpResponse.getWriter();
            writer.print(exp.getMessage());
            writer.flush();
            writer.close();
        }

        filterChain.doFilter(request, response);
    }
}
