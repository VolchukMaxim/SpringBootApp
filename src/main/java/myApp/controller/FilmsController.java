package myApp.controller;

import myApp.model.Films;
import myApp.service.FilmsService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by user on 12.07.2017.
 */

@CrossOrigin(origins = ("*"))
@RestController
public class FilmsController {
    private final Logger Log=LogManager.getLogger(FilmsController.class);

    @Autowired
    @Qualifier
    private FilmsService service;

    @RequestMapping ("/saveFilm")
    public String addFilm(){
        return service.addFilm();
    }
    @RequestMapping (value = "/findAllFilms",method = RequestMethod.GET)
    public List<Films> findAllFilms(){
        return service.findAllFilms();
    }
    @RequestMapping (value = "/findFilm/{filmsName}",method = RequestMethod.GET)
    public Films filmsName(@PathVariable("filmsName") String filmsName){
        return service.findOneFilm(filmsName);
    }
    @RequestMapping (value = "/findFilm/{idFilms}", method = RequestMethod.GET)
    public Films idFilms(@PathVariable("idFilms") int idFilms){
        return service.findOneFilm(idFilms);
    }
    @RequestMapping (value = "/findFilm/{actorInFilmsName}",method = RequestMethod.GET)
    public Films actorInFilmsName(@PathVariable("actorInFilmsName") String actorInFilmsName){
        return service.findOneFilm(actorInFilmsName);
    }
    @RequestMapping (value = "/findFilm/{diectorFilm}",method = RequestMethod.GET)
    public Films diectorFilm(@PathVariable("diectorFilm") String diectorFilm){
        return service.findOneFilm(diectorFilm);
    }




}
