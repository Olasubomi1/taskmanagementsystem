package com.soft.TaskManagementSystem.modules.user.repository;

import com.soft.TaskManagementSystem.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String emailAddress);
    User findByUsername(String username);
    User findByMobileNumber(String mobileNumber);
    User findByUserId(String userId);
}
