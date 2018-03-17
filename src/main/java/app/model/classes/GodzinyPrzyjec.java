package app.model.classes;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Karolina on 08.02.2018.
 */
@Entity
@Table(name = "godz_przyjec")
@Data
public class GodzinyPrzyjec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_godz_przyjec;
    Integer id_lekarza;
    Integer id_poradni;
    Integer dzien;
    Time godz_od;
    Time godz_do;
}
