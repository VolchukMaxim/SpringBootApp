package myApp.service.impl;

import myApp.controller.UserController;
import myApp.model.Status;
import myApp.model.User;
import myApp.repository.UserRepository;
import myApp.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    private final static Logger log = LogManager.getLogger(UserServiceImpl.class);


    @Autowired
    private  UserRepository repository;



    public String addUser () {
        log.info("persist new user ");
        repository.save(new User("John", "Connor", 23, "12245678"));
        repository.save(new User("George", "Lucas", 50, "32222388"));
        repository.save(new User("Sasha", "Couen", 39, "32222388"));
        return "OK";
    }


    public List<User> findAll() {
        List<User> users= (List<User>) repository.findAll();
        log.info("Return all users - "+users);
        return users;
    }

    public User findOne(int id) {
        User user = repository.findOne(id);
        log.info("Find user - " + user + ", by id - " + id);
        return user;
    }

    public String deleteUser (int id){
        log.info("Delete User by ID - "+id);
        repository.delete(id);
        return "Ok";
    }

    public User changeStatus (int id,Status status){
        User user= findOne(id);
        user.setStatus(status);
        user.setDateUp(getCurrentData());
        repository.save(user);
        log.info ("Change user status - "+user);
        return user;
    }

    @Override
    public List<User> getUsersByAgeAfter(int age) {
        return null;
    }

    @Override
    public String addDepartment(int id, String departament) {
        return null;
    }

    private String getCurrentData() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  hh.mm.ss");
        return sdf.format(date);
    }
}
