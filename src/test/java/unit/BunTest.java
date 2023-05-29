package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;

    private final String name;
    private final float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters

    public static Object[][] getData() {
        return new Object[][]{
                {"Ржаная", -10.0F},
                {"Rye", 20.0F},
                {"", 0}
        };
    }


    @Before
    public void createBun(){
        bun = new Bun(name, price);
    }

    @Test
    public void getNameShouldReturnName(){

        String actualName = bun.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getPriceShouldReturnPrice(){
        float actualPrice = bun.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }
}
