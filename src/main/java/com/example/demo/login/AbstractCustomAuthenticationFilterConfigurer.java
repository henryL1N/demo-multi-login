/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo.login;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 * @author Henry Lin badcop@163.com
 */
public abstract class AbstractCustomAuthenticationFilterConfigurer<H extends HttpSecurityBuilder<H>, T extends AbstractCustomAuthenticationFilterConfigurer<H, T, F>, F extends AbstractAuthenticationProcessingFilter>
        extends AbstractHttpConfigurer<T, H> {

    private F authFilter;

    public AbstractCustomAuthenticationFilterConfigurer(F authFilter) {
        this.authFilter = authFilter;
    }

    @Override
    public void configure(H http) throws Exception {
        authFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        addFilter(http, authFilter);
    }

    protected abstract void addFilter(H http, F filter);
}
