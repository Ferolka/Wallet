package com.example.demo.controllers;

import com.example.demo.model.ScheduledTransaction;
import com.example.demo.model.Transactions;
import com.example.demo.model.User;
import com.example.demo.services.ScheduleTranService;
import com.example.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/scheduletran")
public class ScheduleTranController extends AbstractController<ScheduledTransaction, ScheduleTranService> {

    public ScheduleTranController(ScheduleTranService service) {
        super(service);
    }
    @GetMapping("/getUserTransaction/{userId}")
    public ResponseEntity<List<ScheduledTransaction>> list(@PathVariable Long userId){

        return ResponseEntity.ok(service.getUserTransaction(userId));
    }
    @GetMapping("/approve/{schtranId}")
    @ResponseBody
    public Boolean approve(@PathVariable Long schtranId){

        return service.approve(schtranId);
    }
    @GetMapping("/decline/{schtranId}")
    @ResponseBody
    public Boolean decline(@PathVariable Long schtranId){

        return service.decline(schtranId);
    }
}
