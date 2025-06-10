package com.helper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.helper.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}