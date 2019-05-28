package com.groupc.flippedclass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.DefaultDirObjectFactory;
import org.springframework.ldap.core.support.LdapContextSource;

import com.groupc.flippedclass.property.LdapProperties;


@Configuration
public class LdapConfig {
	
	@Autowired
    private LdapProperties ldapProperties;

    @Bean
    public LdapTemplate getLdapTemplate() {
        return new LdapTemplate(this.getLdapContextSource());
    }

    @Bean
    public LdapContextSource getLdapContextSource() {
        LdapContextSource lcs = new LdapContextSource();
        lcs.setUrl(this.ldapProperties.getUrl());
        lcs.setUserDn(this.ldapProperties.getUser());
        lcs.setPassword(this.ldapProperties.getPass());
        lcs.setDirObjectFactory(DefaultDirObjectFactory.class);
        lcs.afterPropertiesSet();
        return lcs;
    }

}
