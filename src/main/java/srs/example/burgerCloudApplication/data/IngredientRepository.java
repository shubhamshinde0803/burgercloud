package srs.example.burgerCloudApplication.data;

import org.springframework.data.repository.CrudRepository;
import srs.example.burgerCloudApplication.domain.Ingredients;

public interface IngredientRepository extends CrudRepository<Ingredients, String> {

}
