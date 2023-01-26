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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String identifier;
    private String categoryName;
    private String topCategory;
    @ManyToOne(cascade = CascadeType.ALL)
    private Store store;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

}
