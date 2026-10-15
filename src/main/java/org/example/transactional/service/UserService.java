package org.example.transactional.service;

import org.example.transactional.entity.User;
import org.example.transactional.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
@Autowired
private UserRepository userRepository;

@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void debit(Long userId, Double amount){

      User user = userRepository.findById(userId).orElseThrow();
      user.setBalance(user.getBalance()-amount);
      userRepository.save(user);

      user.setBalance(user.getBalance()-amount);
      userRepository.save(user);
    }
@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void credit(Long userId, Double amount){

        User user = userRepository.findById(userId).orElseThrow();
        user.setBalance(user.getBalance()+amount);
        userRepository.save(user);

    user.setBalance(user.getBalance()+amount);
    userRepository.save(user);
    }

}
