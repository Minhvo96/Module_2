package CleanCode_Refactoring.Refactor2;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    void testFizz(){
        int number = 3;
        String expected = "Fizz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    void testBuzz(){
        int number = 5;
        String expected = "Buzz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    void testFizzBuzz(){
        int number = 15;
        String expected = "FizzBuzz";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }

    @Test
    void testNone(){
        int number = 1;
        String expected = "1";

        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }
}
