package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void createBun(){
        bun = new Bun("ржаная", 20.01F);
    }

    @Test
    public void getNameShouldReturnName(){

        String actualName = bun.getName();
        Assert.assertEquals("ржаная", actualName);
    }

    @Test
    public void getPriceShouldReturnPrice(){
        float actualPrice = bun.getPrice();
        Assert.assertEquals(20.01F, actualPrice, 0);
    }
}
