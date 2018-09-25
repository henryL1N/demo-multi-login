package com.example.demo.configurer;

import com.example.demo.filter.JsonUsernamePasswordAuthenticationFilter;
import com.example.demo.login.AbstractCustomAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;

	/**
	 * @author will
	 */
	public final class JsonLoginConfigurer<H extends HttpSecurityBuilder<H>> extends
			AbstractCustomAuthenticationFilterConfigurer<H,JsonLoginConfigurer<H>, JsonUsernamePasswordAuthenticationFilter> {

		public JsonLoginConfigurer() {
			super(new JsonUsernamePasswordAuthenticationFilter());
		}

		@Override
		protected void addFilter(H http, JsonUsernamePasswordAuthenticationFilter filter) {
			http.addFilterBefore(filter, JsonUsernamePasswordAuthenticationFilter.class);

		}
	}
