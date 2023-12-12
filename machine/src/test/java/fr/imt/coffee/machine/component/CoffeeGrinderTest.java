package fr.imt.coffee.machine.component;

import fr.imt.coffee.machine.component.BeanTank;
import fr.imt.coffee.machine.component.CoffeeGrinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CoffeeGrinderTest {
    private CoffeeGrinder coffeeGrinder;
    private BeanTank beanTank;
    private final int grindingTime = 1000; // 1 second for example

    @BeforeEach
    public void setUp() {
        coffeeGrinder = new CoffeeGrinder(grindingTime);
        beanTank = Mockito.mock(BeanTank.class);
    }

    @Test
    public void grindCoffee_NominalCase() throws InterruptedException {
        double grindTime = coffeeGrinder.grindCoffee(beanTank);
        assertEquals(grindingTime, grindTime, "The grinding time should match the specified grinding time");
        verify(beanTank, times(1)).increaseVolumeInTank(0.2);
    }
}
