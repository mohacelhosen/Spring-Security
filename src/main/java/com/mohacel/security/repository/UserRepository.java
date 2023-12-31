package com.mohacel.security.repository;

import com.mohacel.security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String username);
    UserEntity findByEmail(String email);
}
