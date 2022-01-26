package gendis.interview.java.question.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class is a unit test class to test the method in TaskOne (gendis.interview.java.question.task1)
 *
 * @author skl
 * @since 2022-01-26
 */
public class TaskOneTest {

    /**
     *  Test the method of TaskOne if it returns a string representing the integer.
     */
    @Test
    public void TestNormalCases(){
        final String errorMessage = "Case failed in method 'TestNormalCases'. Expected Output : %s, However, input Number : %d. Please check!!";

        Map<Integer, String> map = Stream.of(new Object[][] {
                {10, "10"}, {0, "0" }, {-10, "-10"},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        map.forEach(
                (Integer input, String expectedOuput) ->
                Assertions.assertTrue(expectedOuput.equals(new TaskOne().getIntAsString(input)),
                        String.format(errorMessage, expectedOuput, input)));
    }

    /**
     *  Test the method of TaskOne if it returns a string representing the integer.
     *  For this case, the Max and Min value of integer are the input.
     */
    @Test
    public void TestBoundaryCases(){
        final String errorMessage = "Case failed in method 'TestBoundaryCases'. Expected Output : %s, However, input Number : %d. Please check!!";

        Map<Integer, String> map = Stream.of(new Object[][] {
                {Integer.MAX_VALUE, "2147483647"},
                {Integer.MIN_VALUE , "-2147483648"},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        map.forEach(
                (Integer input, String expectedOuput) ->
                        Assertions.assertTrue(expectedOuput.equals(new TaskOne().getIntAsString(input)),
                                String.format(errorMessage, expectedOuput, input)));
    }
}
