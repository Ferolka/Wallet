package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;


//@Service
//public class UserServiceImpl implements UserService {
//
//    private UserRepository userRepository;
//    //private ProductFormToProduct productFormToProduct;
//
//    @Autowired
//    public UserServiceImpl(UserRepository productRepository) {
//        this.userRepository = productRepository;
//       // this.productFormToProduct = productFormToProduct;
//    }
//
//
//    @Override
//    public List<User> listAll() {
//        List<User> users = new ArrayList<>();
//        userRepository.findAll().forEach(users::add); //fun with Java 8
//        return users;
//    }
//
//    @Override
//    public User getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public User saveOrUpdate(User user) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}

//@Service
//public class UserServiceImpl extends GeneralService<User, UserRepository> {
//
//    public UserService(UserRepository repository) {
//        super(repository);
//    }
//
//    @Override
//    public List<Model> listAll() {
//        return null;
//    }
//
//    @Override
//    public Model getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Model saveOrUpdate(Model model) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//}
