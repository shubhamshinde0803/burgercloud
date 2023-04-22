package srs.example.burgerCloudApplication.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import srs.example.burgerCloudApplication.domain.Burger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Long id;
    private Date placedAt;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "street is required")
    private String street;
    @NotBlank(message = "city is required")
    private String city;
    @NotBlank(message = "state is required")
    private String state;
    @NotBlank(message = "zip code is required")
    private String zip;
    @Size(min = 12, message = "credit card number should be 12 digits")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "invalid cvv")
    private String ccCVV;

    private List<Burger> burgers = new ArrayList<>();

    public void addDesign(Burger design) {
        this.burgers.add(design);
    }
}
