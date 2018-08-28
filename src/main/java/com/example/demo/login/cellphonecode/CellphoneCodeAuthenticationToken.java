package com.example.demo.login.cellphonecode;

import com.example.demo.login.IdPrincipal;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Henry Lin badcop@163.com
 */
@Getter
public class CellphoneCodeAuthenticationToken extends AbstractAuthenticationToken {

    private IdPrincipal principal;

    private CellphoneCodeCredentials credentials;

    public CellphoneCodeAuthenticationToken(IdPrincipal principal,
                                            CellphoneCodeCredentials credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(false);
    }

    public CellphoneCodeAuthenticationToken(IdPrincipal principal,
                                            CellphoneCodeCredentials credentials,
                                            Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null;
    }
}
