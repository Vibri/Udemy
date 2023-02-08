import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentUtilTest {



    @Test
    void calculateGPA() {
        int[] students = {100,101};
        char[][] grades = {{'A','A','A'},{'A','A','B'}};
        double[] gpas = StudentUtil.calculateGPA(students,grades);
        assertEquals(4.0    , gpas[0]);
        assertEquals(3.6666666666666665, gpas[1]);
    }
}