package app.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "szczegrezerw")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RezerwacjaDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_rezerwacji;
    String imiel;
    String nazwiskol;
    String opis;
    Date data;
    Time godzina;
    String imie;
    String nazwisko;
    String pesel;
    String email;
    String nr_telefonu;
    Integer id_poradni;
}
