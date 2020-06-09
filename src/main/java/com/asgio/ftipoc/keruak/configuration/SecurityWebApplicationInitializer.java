package com.asgio.ftipoc.keruak.configuration;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer

{
    public SecurityWebApplicationInitializer() {
        super(SecurityConfiguration.class);
    }

}

