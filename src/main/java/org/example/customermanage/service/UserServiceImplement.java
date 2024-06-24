package org.example.customermanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.example.customermanage.exception.DuplicateEmailException;
import org.example.customermanage.model.User;
import org.example.customermanage.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) throws DuplicateEmailException {

          User existedUser = findUserByEmail(user.getEmail());
          if(existedUser != null) {
              throw  new DuplicateEmailException();
          } else {
              userRepository.save(user);
          }
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
