package com.softiwa.user.emprole;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
}
