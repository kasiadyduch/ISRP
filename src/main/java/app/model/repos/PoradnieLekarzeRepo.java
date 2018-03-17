package app.model.repos;

import app.model.classes.PoradnieLekarze;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Karolina on 10.11.2017.
 */
public interface PoradnieLekarzeRepo extends JpaRepository<PoradnieLekarze, Integer> {
}
