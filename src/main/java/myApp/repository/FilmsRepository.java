package myApp.repository;

import myApp.model.Films;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by user on 12.07.2017.
 */

    public interface FilmsRepository extends CrudRepository<Films,Integer>{
        List<Films> findByFilmsNameAfter(String filmsName);

    void delete(String filmsName);
}

