package app.model.repos;

import app.model.classes.Poradnia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Karolina on 29.11.2017.
 */
public interface PoradniaRepo extends JpaRepository<Poradnia, Integer> {
}
