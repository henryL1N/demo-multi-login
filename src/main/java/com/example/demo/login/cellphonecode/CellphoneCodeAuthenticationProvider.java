package com.example.demo.login.cellphonecode;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Henry Lin badcop@163.com
 */
public class CellphoneCodeAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CellphoneCodeAuthenticationToken castedAuthentication = (CellphoneCodeAuthenticationToken) authentication;


        if (null != authentication
                && new CellphoneCodeCredentials("123", "123").equals(authentication.getCredentials())) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("cellphoneAuthority1"));
            authorities.add(new SimpleGrantedAuthority("cellphoneAuthority2"));
            CellphoneCodeAuthenticationToken trustedAuthentication
                    = new CellphoneCodeAuthenticationToken(castedAuthentication.getPrincipal(),
                    castedAuthentication.getCredentials(), authorities);
            authentication.setAuthenticated(true);
            return authentication;
        } else {
            throw new BadCredentialsException("cellphone authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CellphoneCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
