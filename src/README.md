# **Potiong Builder**
These project uses the Builder pattern to create potions

## Classes
* Potion stores data such as name, base, ingredients, and brewing time
* PotionBuilder builds validates a potion step by step
* PotionDirector contains two standard potion recipes
* Main runs the examples and creates a custom potions

## Clean Code

### 1. Clear names

#####   Not like this:  

  `private ing t;`   

##### But like this:   
  `private int brewingTime;`  

   This name clearly tells ud what the value represents   

The project also uses intention-revealing method names such as `setName()`, `setBase()`, `setIngredient()`, and `setBrewingTime()`

### 2. Small methods
##### Not like this:   
  public PotionBuilder setIngredient(String ingredient) {  
  //check the ingredient   
  //add the ingredient  
  //do other unrelated work  
  }

##### But like this:  
  public PotionBuilder setIngredient(String ingredient) {  
    if (ingredient != null && !ingredient.equals("")) {  
      this.ingredients.add(ingredient);  
    }  
  return this;
  }  
  
The method has one responsibility: checking the ingredient and adding it to the list

The other Builder methods are also small and focused on the task

### 3. Each class has one job
##### Not like this:  
//Main contains all steps for creating a healing potion  
  builder.reset()    
.setName("Mana Potion")  
.setBase("Distilled Water")  
.setIngredient("Blue Lotus Leaf")  
.setIngredient("Crystal Dust")  
.setBrewingTime(25)  
.build();

##### But like this: 
director.brewHeealingPotion(builder);  

The **PotionDirector** stores the standard recipe, while **Main** only uses it  
This keeps the recipe separate from the client code and allows the same recipe to be reused  

### 4. Check data before building  
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

These checks are inside build()  
They prevent the Builder from creating a potion with missing required data or an invalid brewing time

### 5. No magic numbers
##### Not like this: 
private int brewingTime = 5;  
public PotionBuilder reset() {  
this.brewingTime = 5;  
return this;  
}  
##### But like this:
private static final int DEFAULT_BREWING_TIME = 5;  
private int brewingTime = DEFAULT_BREWING_TIME;  

The constant gives the number 5 a clear meaning

## Summary
The project demonstrates the Builder pattern using a potion brewing system  

The **PotionBuilder** allows to be created step by step using method chaining  
The **PotionDirector** provides reusable recipes for standard potions, while **Main** demonstrates both standard and custom potion cration  

The code also applies five Clean Code principes:

* Meaningful, intention-revealing names
* Small methods
* Each class has one job
* Check data before building
* No magic numbers

These principes make the code easier to read, understand, and extend
