package srs.example.burgerCloudApplication.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import srs.example.burgerCloudApplication.domain.Burger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Burger_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @ManyToOne
    private User user;

    @NotBlank(message = "name is required")
    private String deliveryName;
    @NotBlank(message = "street is required")
    private String deliveryStreet;
    @NotBlank(message = "city is required")
    private String deliveryCity;
    @NotBlank(message = "state is required")
    private String deliveryState;
    @NotBlank(message = "zip code is required")
    private String deliveryZip;
    @Size(min = 12, message = "credit card number should be 12 digits")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "invalid cvv")
    private String ccCVV;

    @ManyToMany(targetEntity = Burger.class)
    private List<Burger> burgers = new ArrayList<>();

    public void addDesign(Burger design) {
        this.burgers.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
