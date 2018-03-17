package app.model.repos;

import app.model.classes.Gabinet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Karolina on 08.11.2017.
 */
public interface GabinetRepo extends JpaRepository<Gabinet, Integer> {
}
