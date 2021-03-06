package com.bubletea.bubletea.config;

import com.bubletea.bubletea.model.CustomPrincipal;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomUserAuthenticationConverter implements UserAuthenticationConverter {

    private final String SUBJECT = "sub";

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put(USERNAME, authentication.getName());

//        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty())
//            response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));

        return response;
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(USERNAME))
            return new UsernamePasswordAuthenticationToken(
                    new CustomPrincipal(Integer.parseInt(map.get(SUBJECT).toString()), map.get(USERNAME).toString()), "N/A",
                    null);
        return null;
    }
}
