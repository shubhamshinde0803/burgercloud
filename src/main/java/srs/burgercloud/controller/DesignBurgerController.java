package srs.burgercloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import srs.domain.Burger;
import srs.domain.Ingredients;
import srs.domain.Ingredients.Type;

import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignBurgerController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredients> ingredients = Arrays.asList(
                new Ingredients("VGP", "Veg Potato", Type.CATEGORY),
                new Ingredients("NVGC", "Non Veg Chicken", Type.CATEGORY),
                new Ingredients("NVGE", "Non Veg Egg", Type.CATEGORY),
                new Ingredients("MZ", "mozarella", Type.CHEESE),
                new Ingredients("AC", "Amul Cheese", Type.CHEESE),
                new Ingredients("MGM", "Magic Masala", Type.SPICE),
                new Ingredients("DS", "Desi Spicy", Type.SPICE)
        );
        Type[] types = Ingredients.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new Burger());

        return "design";
    }

    @PostMapping
    public String processDesign(@ModelAttribute("design") Burger design) {
        //save the taco design
        //

        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredients> filterByType(
            List<Ingredients> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}