package srs.example.burgerCloudApplication.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import srs.example.burgerCloudApplication.data.IngredientRepository;
import srs.example.burgerCloudApplication.domain.Ingredients;

import java.util.Optional;

@Component
public class IngredientByIdConverter implements Converter<String, Optional<Ingredients>> {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Optional<Ingredients> convert(String id) {
        return Optional.ofNullable(ingredientRepo.findById(id).orElse(null));
    }

}
