package srs.example.burgerCloudApplication.data;

import org.springframework.data.repository.CrudRepository;
import srs.example.burgerCloudApplication.domain.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {

}
