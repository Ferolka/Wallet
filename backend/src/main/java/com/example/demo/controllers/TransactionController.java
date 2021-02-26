package com.example.demo.controllers;

import com.example.demo.model.Transactions;

import com.example.demo.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<Transactions, TransactionService> {

    public TransactionController(TransactionService service) {
        super(service);
    }

//    @GetMapping("/getUserTransaction/{userId}")
//    public String list(@PathVariable Long userId, Model model){
//        model.addAttribute("transactions", service.getUserTransaction(userId));
//        return "transaction/usertranlist";
//    }
}