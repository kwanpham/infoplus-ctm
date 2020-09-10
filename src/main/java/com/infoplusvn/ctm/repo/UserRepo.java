package com.infoplusvn.ctm.repo;

import com.infoplusvn.ctm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
