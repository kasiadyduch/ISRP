package app.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Karolina on 08.11.2017.
 */
@Entity
@Table(name = "rezerwacje")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rezerwacja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_rezerwacji;
    Integer id_lekarza;
    Integer id_pacjenta;
    java.sql.Date data;
    Time godzina;
    Integer id_poradni;
}
