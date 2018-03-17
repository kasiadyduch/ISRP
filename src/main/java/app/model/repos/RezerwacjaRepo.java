package app.model.repos;

import app.model.classes.Rezerwacja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Karolina on 08.11.2017.
 */
public interface RezerwacjaRepo extends JpaRepository<Rezerwacja, Integer> {
}
