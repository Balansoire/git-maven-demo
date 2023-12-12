package fr.imt.coffee.machine.component;

import fr.imt.coffee.machine.component.WaterTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WaterTankTest {
    private WaterTank waterTank;

    @BeforeEach
    public void setUp() {
        double initialVolume = 500;
        double minVolume = 0;
        double maxVolume = 1000;
        waterTank = new WaterTank(initialVolume, minVolume, maxVolume);
    }

    @Test
    public void testDecreaseVolumeInTank_NominalCase() {
        double volumeToDecrease = 100;
        waterTank.decreaseVolumeInTank(volumeToDecrease);
        assertEquals(400, waterTank.getActualVolume());
    }

    @Test
    public void testIncreaseVolumeInTank_NominalCase() {
        double volumeToIncrease = 100;
        waterTank.increaseVolumeInTank(volumeToIncrease);
        assertEquals(600, waterTank.getActualVolume());
    }
}

