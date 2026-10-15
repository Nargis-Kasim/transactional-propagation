package org.example.transactional.controller;

import org.example.transactional.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService service;
    @PostMapping("/transfer")
    public String message(@RequestParam Long senderId,
                          @RequestParam Long receiverId,
                          @RequestParam Double amount) {
        try {
            service.transfer(senderId, receiverId, amount);
        } catch (Exception e) {
            return "transfer failed:"+ e.getMessage();
        }
        return "Transfer completed";
    }
}
