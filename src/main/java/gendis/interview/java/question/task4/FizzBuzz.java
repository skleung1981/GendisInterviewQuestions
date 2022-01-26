package gendis.interview.java.question.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class is original from FizzBuzz in (Task 3).
 * In order to satisfy the Question/Task4, the class is changed in order to support different fizzbuzz game in Question 4.
 *
 * 1. A list of array is added which accepts "Constraint" interface, sort it by order if necessary.
 * 2. In th
 *
 * @author skl
 * @since 2021-01-26
 */
public class FizzBuzz {

    private List<Constraint> constraintRules = new ArrayList<>();

    /**
     * Add Constraint to the list of Rules.
     * @param c
     */
    public void addRules(Constraint c){
        constraintRules.add(c);
        constraintRules = constraintRules.stream()
                .sorted((c1, c2) -> Integer.valueOf(c1.order()).compareTo(c2.order()))
                .collect(Collectors.toList());
    }

    /**
     * The method accepts an integer number and convert to String format based on the rules.
     * By default, if there is no rules or applied rules, it returns numerical value in String format.
     *
     * Given the input number, apply the rules if any and return the value.
     *
     * @param number a value of integer
     * @return Numerical value in String or other values if the rules applied.
     */
    public String getIntAsString(int number) {
        String result = constraintRules.stream()
                .filter(constraint -> constraint.condition(number))
                .map(o->o.output())
                .collect(Collectors.joining());

        if (result.isEmpty()){
            return String.valueOf(number);
        }

        return result;
    }

}
