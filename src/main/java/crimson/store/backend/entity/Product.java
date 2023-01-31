package crimson.store.backend.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private String identifier;
    private String type;
    private String imageUrl;
    private String imageThumb;
    private String shortDesc;
    private String longDesc;
    private float listPrice;
    private float offerPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

}
