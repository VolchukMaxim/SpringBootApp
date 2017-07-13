package myApp.repository;

import myApp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by user on 18.06.2017.
 */
public interface UserRepository extends CrudRepository <User,Integer>{
    List<User> findByAgeAfter(int age);
}
