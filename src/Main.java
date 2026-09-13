public class Main {
public static void main(String[] args) {
    PotionBuilder builder = new PotionBuilder();
    PotionDirector director = new PotionDirector();

    System.out.println("Brewing standard recipes via Director");
    Potion healPotion = director.brewHeealingPotion(builder);
    System.out.println(healPotion);
    Potion manaPotion = director.brewManaPotion(builder);
    System.out.println(manaPotion);

    System.out.println("Brewing custom potion manually");
    Potion customPotion = builder.reset()
            .setName("Invisibility Elixir")
            .setBase("Moonlight dew")
            .setIngredient("Chamelion Tail")
            .setIngredient("Shadow root")
            .setBrewingTime(30)
            .build();
    System.out.println(customPotion);
}
}