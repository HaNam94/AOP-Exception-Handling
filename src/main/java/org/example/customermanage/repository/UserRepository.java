package org.example.customermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.customermanage.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
}
