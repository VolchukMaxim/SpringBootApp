package myApp.service.impl;

import myApp.model.Departament;
import myApp.model.Status;
import myApp.model.User;
import myApp.repository.DepartmentRepository;
import myApp.repository.UserRepository;
import myApp.service.UserService;
import myApp.service.UserSeviseHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static myApp.service.UserSeviseHelper.*;

@Service("employeeService")
public class EmployeesServiceImpl implements UserService {

    private final static Logger log = LogManager.getLogger(EmployeesServiceImpl.class);


    @Autowired
    private UserRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;



    public String addUser () {
        log.info("persist new user ");
        repository.save(addUsers());
        return "OK";
    }


    public List<User> findAll() {
        List<User> users= (List<User>) repository.findAll();
        log.info("Return all employees - "+users);
        return users;
    }

    public User findOne(int id) {
        User user = repository.findOne(id);
        log.info("Find employees - " + user + ", by id - " + id);
        return user;
    }

    public String deleteUser (int id){
        log.info("Delete employees by ID - "+id);
        repository.delete(id);
        return "Ok";
    }

    public User changeStatus (int id,Status status){
        User user= findOne(id);
        user.setStatus(status);
        user.setDateUp(getCurrentData());
        repository.save(user);
        log.info ("Change employees status - "+user);
        return user;
    }

    @Override
    public List<User> getUsersByAgeAfter(int age) {
        log.info("Return employees by age after" + age);
        return repository.findByAgeAfter(age);
    }

    @Override
    public String addDepartment(int id, String departament) {
            User user = repository.findOne(id);
            if (user != null) {
                Departament department = departmentRepository.findByDepartmentName(departament);

//            department.getUsers().add(user);
//            departmentRepository.save(department);

                user.setDepartament(department);
                user.setDateUp(UserSeviseHelper.getCurrentData());
                repository.save(user);
                log.info("employee by id -" + id + "added department");
                return "Ok";
            } else {
                String message = "Error employee by id - " + id + " not found";
                log.info(message);
                return message;
            }
        }
    }



