package CleanCode_Refactoring.Cylinder;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CylinderTest {

    @Test
    void testGetVolume(){
        int radius = 1;
        int height = 2;
        double expected = 18.84955592153876;

        double result = Cylinder.getVolume(radius, height);
        assertEquals(expected, result, 1);
    }
}
