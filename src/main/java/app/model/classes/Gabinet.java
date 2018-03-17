package app.model.classes;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Karolina on 08.11.2017.
 */
@Entity
@Table(name = "gabinety")
@Data
public class Gabinet {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id_gabinetu;
    Integer id_poradni;
}
