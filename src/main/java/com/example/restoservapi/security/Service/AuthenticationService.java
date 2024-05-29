package com.example.restoservapi.security.Service;

import com.example.restoservapi.security.Auth.ApiKeyAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

/******************************************************
 * Esta clase es usada para autenticar a los usuarios
 * basado en el API Key.
 ******************************************************/

public class AuthenticationService {
    private static final String AUTH_TOKEN_HEADER_NAME = "REST-API-KEY";
    private static final String AUTH_TOKEN = "TocToc";

    /*************************************************************************
     * Este método es usado para autenticar a los usuarios basado en el API Key.
     * @param request: HttpServletRequest
     * @return Authentication
     *************************************************************************/

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if(apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }
        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
