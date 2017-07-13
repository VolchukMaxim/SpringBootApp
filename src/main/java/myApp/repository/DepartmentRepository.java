package myApp.repository;

import myApp.model.Departament;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by user on 09.07.2017.
 */
public interface DepartmentRepository extends CrudRepository <Departament, Integer> {

    Departament findByDepartmentName(String departmentName);

}
