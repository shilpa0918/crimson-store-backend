package crimson.store.backend.repo;

import crimson.store.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUserName(String userName);
}
