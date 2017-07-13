package myApp.service.impl;

import myApp.model.Departament;
import myApp.repository.DepartmentRepository;
import myApp.service.DepartmentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 09.07.2017.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final static Logger log = LogManager.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Departament> findAllDepartments() {
        log.info("Find All Departments");
        return (List<Departament>) repository.findAll();
    }

    @Override
    public Departament findDepartmentById(int id) {
        log.info("Find Depertment by ID");
        return repository.findOne(id) ;
    }

    @Override
    public void deleteDepartamentById(int id) {
        log.info("Delete Department by ID "+id);
        repository.delete(id);
    }

    @Override
    public void createDepartment(Departament departament) {
        log.info("Create department "+ departament );
        repository.save(departament);
    }

    @Override
    public Departament findDepartmentByName(String departmentName) {
        log.info("find department by name "+ departmentName);
        return repository.findByDepartmentName(departmentName);
    }
}
