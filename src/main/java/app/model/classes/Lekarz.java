package app.model.classes;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Karolina on 08.11.2017.
 */
@Entity
@Table(name = "lekarze")
@Data
public class Lekarz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_lekarza;
    String imie;
    String nazwisko;
    String pwz;
}