package com.example.demo.services;

import com.example.demo.model.Category;
import com.example.demo.model.ScheduledTransaction;

import com.example.demo.model.Transactions;
import com.example.demo.model.User;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ScheduleTranRepository;

import com.example.demo.repositories.TransactionRepository;
import com.example.demo.repositories.UserRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleTranService extends AbstractService<ScheduledTransaction, ScheduleTranRepository> {

    public ScheduleTranService(ScheduleTranRepository repository) {
        super(repository);
    }
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    public List<ScheduledTransaction> getUserTransaction(Long userId) {

        //List<Transactions> res = repository.getUserTransactions(userId);
        return repository.getUserTransactions(userId);

    }
    public boolean approve(Long schtranId) {
        Optional<ScheduledTransaction> opsch = repository.findById(schtranId);
        if(!opsch.isPresent()){
            return false;
        }
        ScheduledTransaction sch = opsch.get();
        Optional<Category> opcat = categoryRepository.findById(sch.getCategory().getId());
        if(!opcat.isPresent()){
            return false;
        }
        Optional<User> opuser = userRepository.findById(sch.getUser().getId());
        if(!opuser.isPresent()){
            return false;
        }
        Category cat = opcat.get();
        User user = opuser.get();

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Transactions tran = new Transactions();
        tran.setCategory(cat);
        tran.setUser(user);
        tran.setScheduledTransaction(sch);
        tran.setDate(formatter.format(date));
        tran.setAmount(sch.getAmount());
        tran.setIsincome(!cat.isOutcome());
        tran.setComment(sch.getComment());
        transactionRepository.save(tran);
        if(sch.isSchedule()){
           date= DateUtils.addMonths(date,1);
            sch.setNextsend(formatter.format(date));
        }else {
            sch.setStatus((short) 1);
        }

        this.update(sch);
        return true;

    }
    public boolean decline(Long schtranId) {
        Optional<ScheduledTransaction> opsch = repository.findById(schtranId);
        if(!opsch.isPresent()){
            return false;
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        ScheduledTransaction sch = opsch.get();
        if(sch.isSchedule()){
            date= DateUtils.addMonths(date,1);
            sch.setNextsend(formatter.format(date));
        }else {
            sch.setStatus((short) 2);
        }

        this.update(sch);
        return true;
    }
}
