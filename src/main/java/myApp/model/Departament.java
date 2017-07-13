package myApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 09.07.2017.
 */
@Entity
public class Departament {
@Id
@GeneratedValue ( strategy = GenerationType.AUTO)
    private int idDepartament;
    private String departmentName;

    @OneToMany (fetch = FetchType.LAZY,mappedBy ="departament" )
    private Set<User> users=new HashSet<>();

    public Departament(String departmentName) {
        this.departmentName = departmentName;

    }

    public Departament() {

    }

    public int getIdDepartament() {
        return idDepartament;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "idDepartament=" + idDepartament +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
