package gendis.interview.java.question.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class is a unit test class to test all examples for Question 4.
 * It should include all previous cases and additional cases defined in question 4 below
 * 1. Change the output name (4a)
 * 2. Change the output name and rules (e.g. odd/even number) (4b)
 * 3. Generic version (e.g. mixed with multiples of X and even number) (4c)
 *
 * @author skl
 * @since 2021-01-26
 */
public class TaskFourTest {

    /**
     *  Test the method of FizzBuzz if it meets the following rules (It should be same as TaskTwoTest except the FizzBuzz is using rules based for more generic)
     *  1. multiples of 3 return 'Fizz'
     *  2. multiples of 5 return 'Buzz'
     *  3. multiples of 3 and 5 return 'FizzBuzz'
     *
     *  In real FizzBuzz game, the input number should start with 1. Therefore, no rule is applied to ZERO.
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

        FizzBuzz game = new FizzBuzz();
        game.addRules(new Rule<Integer>(2, BUZZ, x -> x > 0 && x % 5 == 0));
        game.addRules(new Rule<Integer>(1, FIZZ, x -> x > 0 && x % 3 == 0));

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(game.getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }

    /**
     *  It is to test if the FizzBuzz meet the requirement of 4a
     *  1. multiples of 3 return 'Fuzz'
     *  2. multiples of 5 return 'Bizz'
     *  3. multiples of 3 and 5 return 'FizzBuzz'
     *
     *  In real FizzBuzz game, the input number should start with 1. Therefore, no rule is applied to ZERO.
     */
    @Test
    public void TestNormalCasesForDifferentOutput(){
        final String errorMessage = "Case fail in method 'TestNormalCasesForDifferentOutput'. Expected Output : %s, However, input Number : %d. Please check!!";
        final String BIZZ = "Bizz";
        final String FUZZ = "Fuzz";

        Map<Integer, String> map = Stream.of(new Object[][] {
                {0, "0"},
                {1, "1"},   {2, "2"},   {3, FUZZ},
                {4, "4"},   {5, BIZZ},  {6, FUZZ},
                {7, "7"},   {8, "8"},   {9, FUZZ},
                {10, BIZZ}, {11, "11"}, {12, FUZZ},
                {13, "13"}, {14, "14"}, {15, FUZZ+BIZZ },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        FizzBuzz game = new FizzBuzz();
        game.addRules(new Rule<Integer>(2, BIZZ, x -> x > 0 && x % 5==0));
        game.addRules(new Rule<Integer>(1, FUZZ, x -> x > 0 && x % 3==0));

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(game.getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }

    /**
     * It is to test if the FizzBuzz meet the requirement of 4b
     * 1. Fozz on odd number,
     * 2. Bozz on even number
     *
     * PS: Zero is even number
     */
    @Test
    public void TestNormalCasesForDifferentOutputAndRules(){
        final String errorMessage = "Case fail in method 'TestNormalCasesForDifferentOutputAndRules'. Expected Output : %s, However, input Number : %d. Please check!!";
        final String BOZZ = "Bozz";
        final String FOZZ = "Fozz";

        Map<Integer, String> map = Stream.of(new Object[][] {
                {0, BOZZ},
                {1, FOZZ},  {2, BOZZ},  {3, FOZZ},  {4, BOZZ},
                {5, FOZZ},  {6, BOZZ},  {7, FOZZ},  {8, BOZZ},
                {9, FOZZ},  {10, BOZZ}, {11, FOZZ}, {12, BOZZ},
                {13, FOZZ}, {14, BOZZ}, {15, FOZZ},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        FizzBuzz game = new FizzBuzz();
        game.addRules(new Rule<Integer>(2, BOZZ, x -> x % 2 == 0));
        game.addRules(new Rule<Integer>(1, FOZZ, x -> x % 2 == 1));

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(game.getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }

    /**
     * It is to test if the FizzBuzz meets the requirement of 4c.
     * A generic version. For example,
     * 1. X on multiples of 3
     * 2. Y on even number
     *
     */
    @Test
    public void TestNormalCasesForDifferentOutputAndMixedRules() {
        final String errorMessage = "Case fail in method 'TestNormalCasesForDifferentOutputAndMixedRules'. Expected Output : %s, However, input Number : %d. Please check!!";
        final String Y = "Y";
        final String X = "X";

        Map<Integer, String> map = Stream.of(new Object[][] {
                {0, Y},
                {1, "1"},   {2, Y},   {3, X},     {4, Y},
                {5, "5"},   {6, X+Y}, {7, "7"},   {8, Y},
                {9, X},     {10, Y},  {11, "11"}, {12, X+Y},
                {13, "13"}, {14, Y},  {15, X},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1] ));

        FizzBuzz game = new FizzBuzz();
        game.addRules(new Rule<Integer>(2, Y, x -> x % 2 == 0));
        game.addRules(new Rule<Integer>(1, X, x -> x > 0 && x % 3==0));

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(game.getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }

    /**
     *  Test the method of FizzBuzz if it returns a string representing the integer.
     *  For this case, the Max and Min value of integer are the input and no rule is added and applied.
     */
    @Test
    public void TestBoundaryCases(){
        final String errorMessage = "Case fail in method 'TestBoundaryCases'. Expected Output : %s, However, input Number : %d. Please check!!";

        Map<Integer, String> map = Stream.of(new Object[][] {
                {Integer.MAX_VALUE, "2147483647"},
                {Integer.MIN_VALUE, "-2147483648"},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        FizzBuzz game = new FizzBuzz();

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(game.getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }
}
