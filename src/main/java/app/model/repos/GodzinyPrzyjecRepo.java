package app.model.repos;

import app.model.classes.GodzinyPrzyjec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Karolina on 08.02.2018.
 */
public interface GodzinyPrzyjecRepo extends JpaRepository<GodzinyPrzyjec, Integer> {

    @Query("select g from GodzinyPrzyjec g, Lekarz l, Poradnia p where g.id_lekarza = l.id_lekarza and g.id_poradni = p.id_poradni and l.nazwisko = ?1 and p.opis = ?2 and g.dzien = ?3")
    List<GodzinyPrzyjec> fGetLekarzsGodzOdByDzien(String nazwisko, String opis, Integer dzien);
}
