package com.example.demo.controllers;

import com.example.demo.model.User;

import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/user")
public class UserController extends AbstractController<User, UserService> {

    public UserController(UserService service) {
        super(service);
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("users", service.getAll());
        return "user/list";
    }
}