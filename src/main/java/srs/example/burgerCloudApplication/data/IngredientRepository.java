package srs.example.burgerCloudApplication.data;

import srs.example.burgerCloudApplication.domain.Ingredients;

public interface IngredientRepository {
    Iterable<Ingredients> findAll();
    Ingredients findOne(String id);
    Ingredients Save(Ingredients ingredient);
}
