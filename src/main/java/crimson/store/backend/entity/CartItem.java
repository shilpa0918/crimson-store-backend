package crimson.store.backend.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int qty;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Cart cart;
    
}
