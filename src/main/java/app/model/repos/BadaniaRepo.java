package app.model.repos;

import app.model.classes.Badania;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Karolina on 16.12.2017.
 */
public interface BadaniaRepo extends JpaRepository<Badania, Integer> {
}
