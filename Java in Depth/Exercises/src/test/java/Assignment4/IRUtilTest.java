package Assignment4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IRUtilTest {

    final String doc = "Jedna dve Honza jde. Tri ctzri jedna. jedna jedna jedna";

    @Test
    void getFrequencyCount() {
        assertEquals(5,IRUtil.getFrequencyCount("JEDNA",doc));
    }

    @Test
    void termFrequency() {
        assertEquals(0.5,IRUtil.termFrequency("JEDNA", doc));

    }

}