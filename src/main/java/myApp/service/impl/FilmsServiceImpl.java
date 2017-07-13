package myApp.service.impl;

import myApp.controller.FilmsController;
import myApp.model.Status;
import myApp.model.Films;
import myApp.repository.FilmsRepository;
import myApp.service.FilmsService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * Created by user on 12.07.2017.
 */
@Service ("filmsServiceImpl")
public class FilmsServiceImpl implements FilmsService {

    private final static Logger log =LogManager.getLogger(FilmsServiceImpl.class);

    @Autowired
    private FilmsRepository repository;

    public String addFilm() {
        log.info("persist new film ");
        repository.save(new Films("Terminator"));
        repository.save(new Films("Star Wars"));
        repository.save(new Films("Borat"));
        return "Persisted new films";
    }

    public List<Films> findAllFilms(){
        List<Films> filmsList=(List<Films>) repository.findAll();
        log.info("return all films= "+filmsList);
        return filmsList;
    }

    @Override
    public Films findOneFilm(String FilmsName) {
        return null;
    }

    public Films findOneFilm(int idFilms){
        Films films=repository.findOne(idFilms);
        log.info("Find film - " + films + ", by id - " + idFilms);
        return films;
    }

    public String deleteFilm(String filmsName){
        log.info("Delete film by filmName - "+filmsName);
        repository.delete(filmsName);
        return "film deleted";

    }

}
