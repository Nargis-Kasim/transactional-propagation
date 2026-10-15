package org.example.transactional.service;

import org.example.transactional.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
public class WalletService {
    @Autowired
    private UserService userService;

    @Transactional
    public void transfer(Long senderId, Long receiverId, Double amount){
        userService.debit(senderId,amount);
        userService.credit(receiverId,amount);
    }
}
