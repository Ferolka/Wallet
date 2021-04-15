package com.example.demo.controllers;

import com.example.demo.ViewModels.CategorySum;
import com.example.demo.ViewModels.TransactionWithSchedulViewModel;
import com.example.demo.model.Transactions;

import com.example.demo.services.TransactionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<Transactions, TransactionService> {

    public TransactionController(TransactionService service) {
        super(service);
    }

    @GetMapping("/getUserTransaction/{userId}")
    public ResponseEntity<List<Transactions>> list(@PathVariable Long userId){

        return ResponseEntity.ok(service.getUserTransaction(userId));
    }
    @GetMapping("/withScheduled/{userId}")
    public ResponseEntity<List<TransactionWithSchedulViewModel>> withScheduled(@PathVariable Long userId){

        return ResponseEntity.ok(service.withScheduled(userId));
    }
    @GetMapping("/categorySum/{userId}")
    public ResponseEntity<List<CategorySum>> categorySum(@PathVariable Long userId){

        return ResponseEntity.ok(service.categorySum(userId));
    }
    @GetMapping("/categoryProcent/{userId}/{isIncome}")
    public ResponseEntity<List<CategorySum>> categoryProcent(@PathVariable Long userId,boolean isIncome){

        return ResponseEntity.ok(service.categoryProcent(userId,isIncome));
    }
}