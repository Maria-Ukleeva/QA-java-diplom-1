package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

@Mock
Ingredient ingredient;
@Mock
Bun bun;
Burger burger;

@Before
    public void createBurger(){
    burger = new Burger();
}

    //переделать
@Test
public void setBunsShouldSetBun(){
    burger.setBuns(bun);
    Assert.assertEquals(bun, burger.bun);
}

@Test
    public void addIngredientShouldAddIngredient(){
    burger.addIngredient(ingredient);
    Assert.assertTrue(burger.ingredients.contains(ingredient));

}
    @Test
    public void removeIngredientShouldRemoveIngredient(){
        burger.ingredients.add(ingredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        Assert.assertFalse(burger.ingredients.contains(ingredient));

    }


    @Test
    public void moveIngredientShouldMoveIngredients(){
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "котлета", 50F);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(1,0);
        Assert.assertEquals(secondIngredient, burger.ingredients.get(0));

    }

    @Test
    public void getPriceShouldReturnFullPrice(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(20F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float price = burger.getPrice();
        Assert.assertEquals(140F, price, 0);
    }

    @Test
    public void getReceiptShouldReturnReceipt(){
        Burger spyBurger = Mockito.spy(burger);
        spyBurger.setBuns(bun);
        spyBurger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(20F);
        Mockito.when(bun.getName()).thenReturn("ржаная булочка");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getName()).thenReturn("кетчуп");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        String receipt = spyBurger.getReceipt();
        Mockito.verify(spyBurger, Mockito.times(1)).getPrice();
        Assert.assertTrue(receipt.contains("(==== ржаная булочка ====)\r\n= sauce кетчуп =\r\n(==== ржаная булочка ====)"));
        Assert.assertTrue(receipt.contains("Price: 140,000000"));
    }

}
