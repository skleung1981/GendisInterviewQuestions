package gendis.interview.java.question.task4;

import java.util.function.Predicate;

/**
 * It is a concrete class which describes a rule by implementing the interface "Constraint".
 * It holds the order and output value if the given condition in
 * @param <T>
 */
public class Rule<T> implements Constraint<T>{

    private int order;
    private String output;
    Predicate<T> condition;

    public Rule(int order, String output, Predicate<T> condition){
        this.order = order;
        this.output = output;
        this.condition = condition;
    }

    @Override
    public int order() {
        return order;
    }

    @Override
    public String output() {
        return output;
    }

    @Override
    public boolean condition(T number) {
        return condition.test(number);
    }

//    @Override
//    public String toString(){
//        return String.format("Order : %d, Output %s ", order, output);
//    }
}
