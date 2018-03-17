package app.model.repos;

import app.model.classes.Lekarz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Karolina on 08.11.2017.
 */
public interface LekarzRepo extends JpaRepository<Lekarz, Integer> {
    @Query("select l from Lekarz l where l.nazwisko like ?1")
    List<Lekarz> findLekarzsByNazwiskoContaining(String s);

    @Query("select l from Lekarz l where l.pwz like ?1")
    Lekarz findLekarzByPwzContaining(String s);

    @Query("select l from Lekarz l, PoradnieLekarze lp, Poradnia p " +
            "where lp.id_lekarza = l.id_lekarza " +
            "      and lp.id_poradni = p.id_poradni " +
            "      and p.opis = ?1")
    List<Lekarz> gfindLekarzsByOpisPoradni(String opis_poradni);
}
