package app.model.classes;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Karolina on 29.11.2017.
 */
@Entity
@Table(name = "poradnie")
@Data
public class Poradnia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_poradni;
    String opis;
}
