package com.groupc.flippedclass.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupc.flippedclass.entity.Role;
import com.groupc.flippedclass.entity.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

	Optional<Role> findByName(RoleName roleName);
}
