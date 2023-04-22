package srs.example.burgerCloudApplication.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import srs.example.burgerCloudApplication.domain.Ingredients;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc){
    this.jdbcTemplate = jdbc;
    }
    @Override
    public Iterable<Ingredients> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredients", this::mapRowToIngredient);
    }

    @Override
    public Ingredients findOne(String id) {
        return jdbcTemplate.queryForObject("select id, name, type from Ingredients whenre id=?", this::mapRowToIngredient, id);
    }

    @Override
    public Ingredients Save(Ingredients ingredient) {
        jdbcTemplate.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredients mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredients(rs.getString("id"),
                rs.getString("name"),
                Ingredients.Type.valueOf(rs.getString("type")));
    }
}
