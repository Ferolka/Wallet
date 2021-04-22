package com.example.demo.controllers;

import com.example.demo.exception.NoSuchUserException;
import com.example.demo.model.User;

import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;




//@Controller
//public class UserController {
//    //private UserService userService;
//
//    //private ProductToProductForm productToProductForm;
//
////    @Autowired
////    public void setProductToProductForm(ProductToProductForm productToProductForm) {
////        this.productToProductForm = productToProductForm;
////    }
//
////    @Autowired
////    public void setProductService(UserService userService) {
////        this.userService = userService;
////
////    }
////    @Autowired
////    public void setProductService(GeneralService<User> generalService) {
////        this.generalService = generalService;
////    }
//public UserController(UserService service) {
//        super(service);
//    }
//    @RequestMapping("/")
//    public String redirToList(){
//        return "redirect:/user/list";
//    }
//
//    @RequestMapping({"/user/list", "/user"})
//    public String listUsers(Model model){
//        model.addAttribute("users", service.getAll());
//        return "user/list";
//    }
//
//}


//@RestController

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserService> {

    public UserController(UserService service) {
        super(service);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam("login") String login,
            @RequestParam("password") String password)
    {
        Long id = service.loginUser(login, password).getId();
        return ResponseEntity.ok(id.toString());
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(
            @RequestParam("name") String name,
            @RequestParam("login") String login,
            @RequestParam("password") String password)
    {
        Long id = service.registerNewUserAccount(name, login, password).getId();
        return ResponseEntity.ok(id.toString());
    }

    @GetMapping("/list")
    public String list(Model model){
        Optional<User> us = service.get(1L);
        model.addAttribute("users", service.getAll());
        return "user/list";
    }

    @GetMapping(value = "getBalance/{id}")
    public ResponseEntity<User> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserBalance(id));
    }
}