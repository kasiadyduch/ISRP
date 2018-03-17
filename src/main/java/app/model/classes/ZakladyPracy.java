package app.model.classes;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Karolina on 16.12.2017.
 */
@Entity
@Table(name = "zaklady_pracy")
@Data
public class ZakladyPracy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_zakladu;
    String nazwa;
    String nip;
    String ulica;
    String nr_budynku;
    String kod_pocztowy;
    String miejscowosc;
}
