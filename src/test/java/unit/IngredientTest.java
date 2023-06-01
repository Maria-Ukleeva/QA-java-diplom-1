package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {SAUCE, "1000 островов", 30},
                {FILLING, "сыр", 15},
        };
    }

    @Before
    public void createIngredient(){
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypeReturnsCorrectType(){
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(type, actualType);
    }

    @Test
    public void getNameReturnsCorrectName(){
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getPriceReturnsCorrectPrice(){
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}
