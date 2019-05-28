package com.groupc.flippedclass.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
public class LdapProperties {

    @Value("${ldap.urls}")
    public String url;

    @Value("${ldap.username}")
    public String user;

    @Value("${ldap.password}")
    public String pass;

    @Value("${ldap.employee_ou}")
    public String employeeOu;

}

