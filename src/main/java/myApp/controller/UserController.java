package myApp.controller;

import myApp.model.Status;
import myApp.model.User;
import myApp.repository.UserRepository;
import myApp.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = ("*"))
@RestController
public class UserController {

    private final static Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    @Qualifier("employeeService")
    private UserService service;


    @RequestMapping ("/save")
    public String addUser () {
      return  service.addUser();
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<User> findAll() {
       return service.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable("id") int id) {
       return service.findOne(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id) {
        return service.deleteUser(id);
    }
    @RequestMapping(value = "/user/{id}/{status}", method = RequestMethod.PUT)
    public User changeStatus(@PathVariable("id") int id, @PathVariable ("status") Status status) {
        return service.changeStatus(id, status);
    }

    @RequestMapping(value = "/age/{age}", method = RequestMethod.GET)
    public List<User> getUsersByAgeAfter (@PathVariable("age") int age) {
        return service.getUsersByAgeAfter(age);
    }



    @RequestMapping(value = "/user/{id}/department/{name}", method = RequestMethod.PUT)
    public String addDepartmentByName(@PathVariable("id") int id, @PathVariable("name") String departmentName) {
        return service.addDepartment(id, departmentName);
    }

    @RequestMapping(value = "/user/dep/{id}", method = RequestMethod.GET)
    public String showDepartment(@PathVariable("id") int id) {
        return service.findOne(id).getDepartament().getDepartmentName();
    }

}
