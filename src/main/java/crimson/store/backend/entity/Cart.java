package crimson.store.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Users users;
    private int qty;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CartItem> cartItems;
}
