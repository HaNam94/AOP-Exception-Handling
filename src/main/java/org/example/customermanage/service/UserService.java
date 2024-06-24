package org.example.customermanage.service;

import org.example.customermanage.exception.DuplicateEmailException;
import org.example.customermanage.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User el) throws DuplicateEmailException;

   void remove(int id);

   // check email exists
    User findUserByEmail(String email);
}
