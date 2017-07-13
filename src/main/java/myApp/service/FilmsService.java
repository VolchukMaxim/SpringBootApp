package myApp.service;

import myApp.model.Films;
import myApp.model.User;
import java.util.List;
/**
 * Created by user on 12.07.2017.
 */
public interface FilmsService {
    String addFilm();

        List<Films> findAllFilms();

        Films findOneFilm(String FilmsName);

        String deleteFilm(String FilmsName);

        Films findOneFilm(int idFilms);


    }

