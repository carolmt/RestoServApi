package com.example.restoservapi.security.Auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/******************************************************
 * Esta clase es usada para autenticar a los usuarios
 * basado en el API Key.
 ******************************************************/
public class ApiKeyAuthentication extends AbstractAuthenticationToken {
    private final String apiKey;

    /*************************************************************************
     * Este método es usado para autenticar a los usuarios basado en el API Key.
     * @param apikey: String
     @param authorities una colección de objetos que extienden de GrantedAuthority
     *************************************************************************/
    public ApiKeyAuthentication(String apikey,  Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.apiKey = apikey;
        setAuthenticated(true);
    }

    /*************************************************************************
     * Este método es usado para obtener las credenciales.
     * @return null
     *************************************************************************/
    @Override
    public Object getCredentials() {
        return null;
    }

    /*************************************************************************
     * Este método es usado para obtener el principal.
     * @return apiKey
     *************************************************************************/
    @Override
    public Object getPrincipal() {
        return apiKey;
    }
}
