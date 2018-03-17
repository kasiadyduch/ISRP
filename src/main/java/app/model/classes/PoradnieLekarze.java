package app.model.classes;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Karolina on 10.11.2017.
 */
@Entity
@Table(name = "poradnie_lekarze")
@Data
public class PoradnieLekarze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer id_poradni;
    Integer id_lekarza;
}
