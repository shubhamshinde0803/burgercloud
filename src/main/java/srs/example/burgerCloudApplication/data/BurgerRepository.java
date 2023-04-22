package srs.example.burgerCloudApplication.data;

import srs.example.burgerCloudApplication.domain.Burger;

public interface BurgerRepository {

    Burger save(Burger burger);
}
