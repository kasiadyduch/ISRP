package app.model.repos;

import app.model.classes.RezerwacjaDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;

public interface RezerwacjaDetailsRepo extends JpaRepository<RezerwacjaDetails, Integer> {

    @Query("select r from RezerwacjaDetails r where r.data = ?1 and r.godzina = ?2 and r.id_poradni = ?3")
    RezerwacjaDetails getRezerwacjaDetails(Date data_rezerwacji, Time godzina_rezerwacji, Integer id_poradni);
}
