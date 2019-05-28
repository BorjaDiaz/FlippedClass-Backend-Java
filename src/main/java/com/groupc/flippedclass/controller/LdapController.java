package com.groupc.flippedclass.controller;


import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

import com.groupc.flippedclass.dto.TopicDto;
import com.groupc.flippedclass.dto.User;
import com.groupc.flippedclass.property.LdapProperties;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LdapController {
	@Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private LdapProperties ldapProperties;

    private class UserAttributesMapper implements AttributesMapper<User> {
        public User mapFromAttributes(Attributes attrs) throws NamingException {
            User user = new User();
            user.setFullName((String)attrs.get("cn").get());
            user.setLastName((String)attrs.get("sn").get());
            user.setCostCenter((String)attrs.get("aoCostCenter").get());
            user.setJobPosition((String)attrs.get("aoJobPosition").get());
            user.setMail((String)attrs.get("mail").get());
            user.setServiceLine((String)attrs.get("aoServiceLine").get());
            user.setStreet((String)attrs.get("street").get());
            return user;
        }
    }


    @GetMapping("api/authenticate/{das}")
    public Object getAllPersonNames(@PathVariable String das) {
        AndFilter filter = new AndFilter().and(new EqualsFilter("uid", das));
        return ldapTemplate.authenticate(ldapProperties.getEmployeeOu(), filter.toString(),
                "");

    }
    
    @GetMapping("api/getUserByDas/{das}")
    public Object getAllPersons(@PathVariable String das) {
        LdapQuery query = query()
                .base("dc=myOrg")
                //.attributes("cn", "sn", "dn") -> si ponemos atributes solo traerá esos atributos
                .where("objectclass").is("person")
                .and("uid").is(das); //uid hace referencia al DAS del empleado en el LDAP
         return ldapTemplate.search(query, new UserAttributesMapper());
    }
	
}
