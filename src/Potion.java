import java.util.ArrayList;
import java.util.List;

public class Potion {
    private String name;
    private String base;
    private List<String> ingredients = new ArrayList<>();
    private int brewingTime;

Potion(String name, String base, List<String> ingredients, int brewingTime) {
    this.name = name;
    this.base = base;
    this.ingredients = ingredients;
    this.brewingTime = brewingTime;
}

@Override
    public String toString() {
    return "Potion: " + name +
            "Base: " + base +
            "Ingredients: " + ingredients +
            "Brewing time: " + brewingTime + "mins\n";
}

}