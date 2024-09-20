package com.IdentityServicePostgreSQL.demo.repository;

import com.IdentityServicePostgreSQL.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}
