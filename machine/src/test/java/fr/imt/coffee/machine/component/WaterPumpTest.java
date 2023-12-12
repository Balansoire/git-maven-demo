package fr.imt.coffee.machine.component;

import fr.imt.coffee.machine.component.WaterPump;
import fr.imt.coffee.machine.component.WaterTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WaterPumpTest {
    private WaterPump waterPump;
    private WaterTank waterTank;
    private final double pumpingCapacity = 1.0; // 1 litre par seconde pour l'exemple

    @BeforeEach
    public void setUp() {
        waterPump = new WaterPump(pumpingCapacity);
        waterTank = Mockito.mock(WaterTank.class);
    }

    @Test
    public void pumpWater_NominalCase() throws InterruptedException {
        double waterVolume = 2.0; // 2 litres d'eau à pomper
        double expectedPumpingTime = (waterVolume / pumpingCapacity) * 1000 * 2;
        double actualPumpingTime = waterPump.pumpWater(waterVolume, waterTank);

        assertEquals(expectedPumpingTime, actualPumpingTime, "Pumping time should match the calculated value");
        verify(waterTank, times(1)).decreaseVolumeInTank(waterVolume);
    }
}
