package fr.imt.coffee.machine.component;

import fr.imt.coffee.machine.component.SteamPipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SteamPipeTest {
    private SteamPipe steamPipe;

    @BeforeEach
    public void setUp() {
        steamPipe = new SteamPipe();
    }

    @Test
    public void steamPipeShouldBeOffByDefault() {
        assertFalse(steamPipe.isOn(), "SteamPipe should be off by default.");
    }

    @Test
    public void setOnShouldTurnSteamPipeOn() {
        steamPipe.setOn();
        assertTrue(steamPipe.isOn(), "setOn should turn SteamPipe on.");
    }

    @Test
    public void setOffShouldTurnSteamPipeOff() {
        steamPipe.setOn(); // Turn it on first
        steamPipe.setOff(); // Now turn it off
        assertFalse(steamPipe.isOn(), "setOff should turn SteamPipe off.");
    }
}
