package com.soft.TaskManagementSystem.modules.user.repository;

import com.soft.TaskManagementSystem.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String emailAddress);
    User findByUsername(String username);
    User findByMobileNumber(String mobileNumber);
}
