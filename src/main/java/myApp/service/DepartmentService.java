package myApp.service;

import myApp.model.Departament;

import java.util.List;

/**
 * Created by user on 09.07.2017.
 */
public interface DepartmentService {

    List <Departament> findAllDepartments();
    Departament findDepartmentById (int id);
    void deleteDepartamentById (int id);
    void createDepartment (Departament departament);
    Departament findDepartmentByName (String departmentName);

}
