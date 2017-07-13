package myApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by user on 11.07.2017.
 */

@Entity
@Table(name = "Films")
public class Films {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idFilms;
    private String filmsName;
    private String actorInFilmsName;
    private String diectorFilm;

    @JsonIgnore
    @ManyToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Departament departament;
    private User user;
    private Films films;

    public Films(int idFilms, String filmsName, String actorInFilmsName, String diectorFilm, Films films) {
        this.idFilms = idFilms;
        this.filmsName = filmsName;
        this.actorInFilmsName = actorInFilmsName;
        this.diectorFilm = diectorFilm;
        this.films = films;
    }
//    private Set <User> users=new HashSet<>();
//    private Set <Departament> departaments=new HashSet<>();
//
//    //for what this?
//    public Films (String filmsName){
//        this.filmsName=filmsName;
//    }
    public Films(String terminator) {
    }

    public int getIdFilms() {
        return idFilms;
    }
    public String getFilmsName() {
        return filmsName;
    }
    public void setFilmsName(String filmsName){
        this.filmsName=filmsName;
    }
    public String getActorInFilmsName(){
        return actorInFilmsName;
    }
    public String getDiectorFilm(){
        return diectorFilm;
    }
    public String getfilms (){
        return filmsName;
    }

    @Override
    public String toString(){
        return "Film{" +
                "id Film=" + idFilms +
                ", film Name='" + filmsName + '\'' +
                ", actor in film Name='" + actorInFilmsName + '\'' +
                ", director film Name=" + diectorFilm +
                '}';
    }


}
