package srs.example.burgerCloudApplication.data;

import org.springframework.data.repository.CrudRepository;
import srs.example.burgerCloudApplication.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
