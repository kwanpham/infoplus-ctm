package com.infoplusvn.ctm.repo;

import com.infoplusvn.ctm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
