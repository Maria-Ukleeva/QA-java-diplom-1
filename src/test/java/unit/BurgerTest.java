package unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

   private Burger burger;

@Mock
Ingredient ingredient;
Bun bun;

@Before
    public void createBurger(){
    burger = new Burger();
}

@Test
    public void addIngredientShouldIngredient(){
    //List<Ingredient> ingredients = burger.addIngredient(ingredient);

}


}
