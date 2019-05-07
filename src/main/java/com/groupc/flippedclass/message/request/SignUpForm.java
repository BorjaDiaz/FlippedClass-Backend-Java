package com.groupc.flippedclass.message.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SignUpForm {
	
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String surname;
 
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
 
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    
    @Size(min = 6, max = 100)
    private String password;
    
    private Set<String> role;
    
    private boolean enabled;
     
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getUsername() {
        return username;
    }
    
    public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

    
}