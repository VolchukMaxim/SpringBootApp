package myApp.service;

import myApp.model.Departament;
import myApp.model.Films;
import myApp.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 25.06.2017.
 */
public class UserSeviseHelper {
    public static String getCurrentData() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  hh.mm.ss");
        return sdf.format(date);
    }

    public static List<User> addUsers(){
        List<User> users=new ArrayList<>();
        users.add(new User("John", "Connor", 23, "12245678"));
        users.add(new User("George", "Lucas", 50, "32222388"));
        users.add(new User("Sasha", "Couen", 39, "32222388"));
        return users;
    }

    public static List<Departament> addDepartments(){
        List<Departament> departaments=new ArrayList<>();
        departaments.add(new Departament("Director"));
        departaments.add(new Departament("Actor"));
        return departaments;
    }


}
