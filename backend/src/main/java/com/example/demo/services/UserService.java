package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 1/10/17.
 */
//public interface UserService {
//
//    List<User> listAll();
//
//    User getById(Long id);
//
//    User saveOrUpdate(User user);
//
//    void delete(Long id);
//
//    //Product saveOrUpdateProductForm(ProductForm productForm);
//}
@Service
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }

}
