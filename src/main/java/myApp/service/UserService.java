package myApp.service;

import myApp.model.Status;
import myApp.model.User;

import java.util.List;

/**
 * Created by user on 25.06.2017.
 */
public interface UserService {
    String addUser();

    List<User> findAll();

    User findOne(int id);

    String deleteUser (int id);

    User changeStatus (int id,Status status);

    List<User> getUsersByAgeAfter (int age);

    String addDepartment(int id, String departament);
}
