package gendis.interview.java.question.task3;

/**
 * The class is original from TaskOne. In order to satisfy the Test case (Question/Task2), the method is changed.
 *
 * @author skl
 * @since 2021-01-26
 */
public class FizzBuzz {

    /**
     * The method accepts an integer number and convert to String format.
     * e.g. input : 14     output : "14"
     * And there are additional rules as below
     *
     * 1. input : (multiples of 3)   output : "Fizz"
     * 2. input : (multiples of 5)   output : "Buzz"
     * 3. input : (multiples of 3 and 5) output : "FizzBuzz"
     *
     * @apiNote Please note that Zero value is handled to return number in String.
     * In real FizzBuzz game, the input number should start with 1.
     *
     * @param number a value of integer
     * @return Numerical value in String or 'Fizz'/'Buzz'/'FizzBuzz' if condition is met.
     */
    public String getIntAsString(int number) {
        if (number == 0) {
            return String.valueOf(number);
        } else if (number % 3 == 0 && number % 5 == 0){
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
