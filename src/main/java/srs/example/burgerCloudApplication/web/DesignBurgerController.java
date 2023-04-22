package srs.example.burgerCloudApplication.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import srs.example.burgerCloudApplication.data.BurgerRepository;
import srs.example.burgerCloudApplication.data.IngredientRepository;
import srs.example.burgerCloudApplication.domain.Burger;
import srs.example.burgerCloudApplication.domain.Ingredients;
import srs.example.burgerCloudApplication.domain.Order;

import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignBurgerController {

    private final IngredientRepository ingredientRepo;
    private BurgerRepository designRepo;

    @Autowired
    public DesignBurgerController(IngredientRepository ingredientRepo, BurgerRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "burger")
    public Burger burger(){
        return new Burger();
    }


    @GetMapping
    public String showDesignForm(Model model) {
//        model.addAttribute("design", new Burger());
        List<Ingredients> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        Ingredients.Type[] types = Ingredients.Type.values();
        for (Ingredients.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Burger design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            System.out.println("process design has errors");
            return "design";
        }
        //save the taco design
        Burger saved = designRepo.save(design);
        //
        order.addDesign(saved);
        System.out.println("process method called");
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredients> filterByType(
            List<Ingredients> ingredients, Ingredients.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
