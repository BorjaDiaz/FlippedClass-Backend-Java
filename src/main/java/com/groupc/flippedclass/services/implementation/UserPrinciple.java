package com.groupc.flippedclass.services.implementation;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.groupc.flippedclass.entity.User;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private boolean enabled;
	
	public UserPrinciple(Long id, String name, 
            String username, String email, String password, 
            Collection<? extends GrantedAuthority> authorities, boolean enabled) {
      this.id = id;
      this.name = name;
      this.username = username;
      this.email = email;
      this.password = password;
      this.authorities = authorities;
      this.enabled = enabled;
  }

	public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().<GrantedAuthority>map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
 
        return new UserPrinciple(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities,
                user.isEnabled()
        );
    }
	
	public Long getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public String getEmail() {
        return email;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
