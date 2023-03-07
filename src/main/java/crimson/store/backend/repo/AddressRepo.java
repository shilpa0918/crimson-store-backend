package crimson.store.backend.repo;

import crimson.store.backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    List<Address> findAddressesByUsersId(Integer userId);
}
