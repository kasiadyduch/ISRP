package app.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Karolina on 08.11.2017.
 */
@Entity
@Table(name = "pacjenci")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacjent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_pacjenta;
    String imie;
    String nazwisko;
    String pesel;
    String nr_telefonu;
    String ulica;
    String nr_domu;
    String kod_pocztowy;
    String miejscowosc;
    String email;
    Integer id_zakladu;
    String nr_lokalu;
}
