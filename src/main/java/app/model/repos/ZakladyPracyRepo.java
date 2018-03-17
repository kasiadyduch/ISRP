package app.model.repos;

import app.model.classes.ZakladyPracy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Karolina on 16.12.2017.
 */
public interface ZakladyPracyRepo extends JpaRepository<ZakladyPracy, Integer> {
}
