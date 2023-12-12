package fr.imt.coffee.machine.component;

import fr.imt.coffee.machine.component.BeanTank;
import fr.imt.coffee.storage.type.CoffeeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BeanTankTest {

    private BeanTank beanTank;
    private final double initialVolume = 1.0;
    private final double minVolume = 0.1;
    private final double maxVolume = 10.0;
    private final CoffeeType initialCoffeeType = CoffeeType.ARABICA;

    @BeforeEach
    void setUp() {
        beanTank = new BeanTank(initialVolume, minVolume, maxVolume, initialCoffeeType);
    }

    @Test
    void testConstructor() {
        assertEquals(initialVolume, beanTank.getActualVolume());
        assertEquals(minVolume, beanTank.getMinVolume());
        assertEquals(maxVolume, beanTank.getMaxVolume());
        assertEquals(initialCoffeeType, beanTank.getBeanCoffeeType());
    }

    @Test
    void testIncreaseCoffeeVolumeInTank() {
        double increaseVolume = 1.0;
        CoffeeType newCoffeeType = CoffeeType.ARABICA;
        beanTank.increaseCoffeeVolumeInTank(increaseVolume, newCoffeeType);
        assertEquals(initialVolume + increaseVolume, beanTank.getActualVolume());
        assertEquals(newCoffeeType, beanTank.getBeanCoffeeType());
    }

    @Test
    void testAddWrongCoffeeType() {
        double increaseVolume = 1.0;
        CoffeeType newCoffeeType = CoffeeType.ROBUSTA;
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                beanTank.increaseCoffeeVolumeInTank(increaseVolume, newCoffeeType)
        );
        assertTrue(exception.getMessage().contains("You can't mix two different types of coffee in the same tank"));
    }

    @Test
    void testIncreaseCoffeeVolumeInTankBeyondMax() {
        double increaseVolume = maxVolume + 1; // intentionally beyond max to test boundary
        CoffeeType newCoffeeType = CoffeeType.ARABICA;
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                beanTank.increaseCoffeeVolumeInTank(increaseVolume, newCoffeeType)
        );
        assertTrue(exception.getMessage().contains("You can't put more coffee than the tank can contain"));
    }

    @Test
    void testDecreaseCoffeeVolumeInTank() {
        double increaseVolume = -1.0;
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                beanTank.increaseCoffeeVolumeInTank(increaseVolume, initialCoffeeType)
        );
        assertTrue(exception.getMessage().contains("You can't put a negative volume of coffee"));
    }

    @Test
    void testIncreaseCoffeeVolumeInTankWithNullCoffeeType() {
        double increaseVolume = 1.0;
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                beanTank.increaseCoffeeVolumeInTank(increaseVolume, null)
        );
    }
}
