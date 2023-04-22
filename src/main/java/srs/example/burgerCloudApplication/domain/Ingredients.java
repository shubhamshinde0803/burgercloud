package srs.example.burgerCloudApplication.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredients {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        CATEGORY, CHEESE, SPICE
    }
}
