package myApp.controller;

import myApp.model.Departament;
import myApp.service.DepartmentService;
import myApp.service.UserSeviseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 09.07.2017.
 */
@CrossOrigin(origins = ("*"))
@RestController
@RequestMapping (value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String createDepartment(@RequestBody Departament departament) {
        service.createDepartment(departament);
        return "Create Ok";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveDepartment() {
        for (Departament department: UserSeviseHelper.addDepartments()){
            service.createDepartment(department);
        }
        return "Save";
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Departament> findAll() {
        return service.findAllDepartments();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Departament findOne(@PathVariable("id") int id) {
        return service.findDepartmentById(id);
    }

    @RequestMapping(value = "/dep/{name}", method = RequestMethod.GET)
    public  Departament findByName(@PathVariable("name") String name) {
        return service.findDepartmentByName(name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByID(@PathVariable("id") int id) {
        service.deleteDepartamentById(id);
        return "Delete by Id OK";
    }


}
