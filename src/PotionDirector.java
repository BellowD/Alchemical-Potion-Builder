public class PotionDirector {
public Potion brewHeealingPotion(PotionBuilder builder) {
    return builder.reset()
            .setName("Healing Potion")
            .setBase("Purified Spring Water")
            .setIngredient("Red Herb")
            .setIngredient("Glowing Mushroom")
            .setBrewingtime(15)
            .build();
}
public Potion brewManaPotion(PotionBuilder builder) {
    return builder.reset()
            .setName("Mana Potion")
            .setBase("Distilled Water")
            .setIngredient("Blue Lotus Leaf")
            .setIngredient("Crystal Dust")
            .setBrewingtime(25)
            .build();
}
}
