package com.groupc.flippedclass.services;

import java.util.Set;

import com.groupc.flippedclass.entity.Role;

public interface RoleService {

	public Set<Role> getValidRoles(Set<String> strRoles);
}
