package app.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Karolina on 16.12.2017.
 */
@Entity
@Table(name = "rezerwacje_mp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RezerwacjeMP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_mp;
    Integer id_pacjenta;
    Integer id_zakladu;
    Integer id_badania;
    java.sql.Date data;

}
