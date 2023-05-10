package srs.example.burgerCloudApplication.data;

import org.springframework.data.repository.CrudRepository;
import srs.example.burgerCloudApplication.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
