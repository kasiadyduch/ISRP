package app.model.repos;

import app.model.classes.Pacjent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Karolina on 08.11.2017.
 */
public interface PacjentRepo extends JpaRepository<Pacjent, Integer> {
    @Query("select p from Pacjent p where p.nazwisko like ?1")
    List<Pacjent> findPacjentsByNazwiskoContaining(String s);

    @Query("select p from Pacjent p where p.pesel like ?1")
    Pacjent findPacjentByPeselContaining(String s);
}
