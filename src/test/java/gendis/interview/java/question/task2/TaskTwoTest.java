package gendis.interview.java.question.task2;

import gendis.interview.java.question.task3.FizzBuzz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class is a unit test class to test the method in FizzBuzz.
 * And this unit test class is used to test the FizzBuzz which created in Question/Task 3.
 *
 * @author skl
 * @since 2021-01-26
 */
public class TaskTwoTest {

    /**
     *  Test the method of FizzBuzz if it meets the following rules
     *  1. multiples of 3 return 'Fizz'
     *  2. multiples of 5 return 'Buzz'
     *  3. multiples of 3 and 5 return 'FizzBuzz'
     */
    @Test
    public void TestNormalCases(){
        final String errorMessage = "Case fail in method 'TestNormalCases'. Expected Output : %s, However, input Number : %d. Please check!!";
        final String FIZZ = "Fizz";
        final String BUZZ = "Buzz";
        Map<Integer, String> map = Stream.of(new Object[][] {
                {0, "0"},
                {1, "1"},     {2, "2"},    {3, FIZZ},
                {4, "4"},     {5, BUZZ},   {6, FIZZ},
                {7, "7"},     {8, "8"},    {9, FIZZ},
                {10, BUZZ},   {11, "11"},  {12, FIZZ},
                {13, "13"},   {14, "14"},  {15, FIZZ+BUZZ},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1] ));

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(new FizzBuzz().getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }

    /**
     *  Test the method of FizzBuzz if it returns a string representing the integer.
     *
     *  For this case, the Max and Min value of integer are the input.
     */
    @Test
    public void TestBoundaryCases(){
        final String errorMessage = "Case fail in method 'TestBoundaryCases'. Expected Output : %s, However, input Number : %d .Please check!!";

        Map<Integer, String> map = Stream.of(new Object[][] {
                {Integer.MAX_VALUE, "2147483647"},
                {Integer.MIN_VALUE, "-2147483648"},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(new FizzBuzz().getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }
}
