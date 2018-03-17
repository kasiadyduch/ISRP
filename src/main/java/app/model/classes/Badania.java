package app.model.classes;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Karolina on 16.12.2017.
 */
@Entity
@Table (name = "badania")
@Data
public class Badania {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id_badania;
    String typ_badania;
}
