package br.com.waterclock.api.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.*;
import java.util.stream.Collectors;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(
            OAuth2AccessToken accessToken,
            OAuth2Authentication authentication) {
        Set<String> scopes = authentication.getAuthorities()
                .stream()
                .map(s -> s.toString().toLowerCase())
                .collect(Collectors.toCollection(HashSet::new));
        Map<String, Object> additionalInfo = new HashMap<>();
        User user = (User) authentication.getPrincipal();
        additionalInfo.put("email", user.getUsername());
        additionalInfo.put("isAdmin", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).contains("WRITE_PRIVILEGE"));
        additionalInfo.put("organization", "waterclock");
        ((DefaultOAuth2AccessToken) accessToken).setScope(scopes);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
