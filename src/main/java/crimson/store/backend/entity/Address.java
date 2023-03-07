package crimson.store.backend.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String addressLine1;
    private String addressLine2;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;

}
