package srs.example.burgerCloudApplication.data;

import srs.example.burgerCloudApplication.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
