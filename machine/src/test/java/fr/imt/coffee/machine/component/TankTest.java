package fr.imt.coffee.machine.component;

import fr.imt.coffee.machine.component.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TankTest {
    private Tank tank;

    @BeforeEach
    public void setUp() {
        double initialVolume = 500;
        double minVolume = 0;
        double maxVolume = 1000;
        tank = new Tank(initialVolume, minVolume, maxVolume);
    }

    @Test
    public void testDecreaseVolumeInTank_NominalCase() {
        double volumeToDecrease = 100;
        tank.decreaseVolumeInTank(volumeToDecrease);
        assertEquals(400, tank.getActualVolume());
    }

    @Test
    public void testIncreaseVolumeInTank_NominalCase() {
        double volumeToIncrease = 100;
        tank.increaseVolumeInTank(volumeToIncrease);
        assertEquals(600, tank.getActualVolume());
    }

    @Test
    public void testIncreaseVolumeInTank_OverMaxVolume() {
        double volumeToIncrease = 600;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tank.increaseVolumeInTank(volumeToIncrease);
        });
        assertEquals("You can't increase the volume above the maximum volume", exception.getMessage());
    }

    @Test
    public void testDecreaseVolumeInTank_BelowMinVolume() {
        double volumeToDecrease = 600;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tank.decreaseVolumeInTank(volumeToDecrease);
        });
        assertEquals("You can't decrease the volume below the minimum volume", exception.getMessage());
    }

    @Test
    public void testIncreaseVolumeInTank_NegativeInput() {
        double volumeToIncrease = -100;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tank.increaseVolumeInTank(volumeToIncrease);
        });
        assertEquals("You can't increase the volume with a negative value", exception.getMessage());
    }

    @Test
    public void testDecreaseVolumeInTank_NegativeInput() {
        double volumeToDecrease = -100;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tank.decreaseVolumeInTank(volumeToDecrease);
        });
        assertEquals("You can't decrease the volume with a negative value", exception.getMessage());
    }
}
