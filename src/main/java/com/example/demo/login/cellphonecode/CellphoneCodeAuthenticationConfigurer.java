package com.example.demo.login.cellphonecode;

import com.example.demo.login.AbstractCustomAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Henry Lin badcop@163.com
 */
public final class CellphoneCodeAuthenticationConfigurer<H extends HttpSecurityBuilder<H>> extends
        AbstractCustomAuthenticationFilterConfigurer<H, CellphoneCodeAuthenticationConfigurer<H>, CellphoneCodeAuthenticationFilter> {

    public CellphoneCodeAuthenticationConfigurer() {
        super(new CellphoneCodeAuthenticationFilter());
    }

    @Override
    protected void addFilter(H http, CellphoneCodeAuthenticationFilter filter) {
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
