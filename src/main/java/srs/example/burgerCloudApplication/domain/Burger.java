package srs.example.burgerCloudApplication.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 5, message = "name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity = Ingredients.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredients> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
