package com.example.demo.controllers;

import com.example.demo.model.ScheduledTransaction;
import com.example.demo.model.User;
import com.example.demo.services.ScheduleTranService;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scheduletran")
public class ScheduleTranController extends AbstractController<ScheduledTransaction, ScheduleTranService> {

    public ScheduleTranController(ScheduleTranService service) {
        super(service);
    }
}
