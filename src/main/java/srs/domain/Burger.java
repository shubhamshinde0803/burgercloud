package srs.domain;

import lombok.Data;

import java.util.List;

@Data
public class Burger {
    private String name;
    private List<String> ingredients;
}
