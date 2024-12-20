package ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits.
 */
public class Ex1Test {
    @Test
    void isNumberTest() {
        String numbers[] = new String[]{"135bA", "100111b2", "12345b6","012b5", "123bG", "EFbG"};
        for (int i = 0; i < numbers.length; i++) {
            assertTrue(Ex1.isNumber(numbers[i]));
        }
        String notNumbers[] = new String[]{"b2", "0b1", "123b", "1234b11", "3b3", "-3b5", "3 b4", "GbG", "", null};
        for (int i = 0; i < notNumbers.length; i++) {
            assertFalse(Ex1.isNumber(notNumbers[i]));
        }
    }

    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
       int x = 100;
       int base = 2;
       assertEquals("1100100b2", Ex1.int2Number(x, base));
    }
    @Test
    void maxIndexTest() {
        // implement this test
        String[] arr = {"123bA","154bA","122bF","12b3"};
        assertEquals(2, Ex1.maxIndex(arr));
    }

    // Add additional test functions - test as much as you can.
}
