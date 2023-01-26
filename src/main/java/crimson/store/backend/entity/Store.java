package crimson.store.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Store {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String identifier;
    private String language;
    private String storeName;
    private String model;
    private String currency;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;
}
