package com.example.demo.services;

import com.example.demo.exception.NoSuchUserException;
import com.example.demo.exception.UserAlreadyExistException;
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

    public User registerNewUserAccount(String name, String login, String password)
            throws UserAlreadyExistException {

        List<User> u = repository.getUserByLogin(login);

        if (u == null || u.size()<1){
            repository.insertUser(name, 0.0, login, password);
            return repository.getUserByLogin(login).get(0);
        }else
            throw new UserAlreadyExistException("There is an account with that login: "  +  login);
    }

    public User loginUser(String login, String password) throws NoSuchUserException {
        List<User> u = repository.getUserByLoginAndPassword(login, password);
        return getUser(u);
    }

    public User getUserById(Long id)throws NoSuchUserException {
        List<User> u = repository.getUserById(id);
        return getUser(u);
    }

    private User getUser(List<User> list) throws NoSuchUserException {
        if (list == null || list.size()<1)
            throw new NoSuchUserException("User does not exist");
        else
            return list.get(0);
    }

}
