import java.util.ArrayList;
import java.util.List;


public class PotionBuilder {
    private String name;
    private String base;
    private List<String> ingredients = new ArrayList<>();
    private int brewingTime = 5;

    public PotionBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PotionBuilder setBase(String base) {
        this.base = base;
        return this;
    }

    public PotionBuilder setIngredient(String ingredient) {
        if (ingredient != null && !ingredient.equals("")) {
            this.ingredients.add(ingredient);
        }
        return this;
    }

    public PotionBuilder setBrewingtime(int brewingTime) {
        this.brewingTime = brewingTime;
        return this;
    }

    public PotionBuilder reset() {
        this.name = null;
        this.base = null;
        this.ingredients.clear();
        this.brewingTime = 5;
        return this;
    }

    public Potion build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Potion must have a name");
        }
        if (base == null) {
            throw new IllegalStateException("Cannot brew without a base liquid");
        }
        if (brewingTime <= 0) {
            throw new IllegalArgumentException("Brewing time must be positive");
        }
        return new Potion(name, base, new ArrayList<>(ingredients), brewingTime);
    }
}
