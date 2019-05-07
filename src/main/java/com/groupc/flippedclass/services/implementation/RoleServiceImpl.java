package com.groupc.flippedclass.services.implementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.entity.Role;
import com.groupc.flippedclass.entity.RoleName;
import com.groupc.flippedclass.repository.RoleRepository;
import com.groupc.flippedclass.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Set<Role> getValidRoles(Set<String> strRoles) {
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "teacher":
				Role teacherRole = roleRepository.findByName(RoleName.ROLE_TEACHER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(teacherRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		return roles;
	}

}
