package gendis.interview.java.question.task4;

/**
 * A interface "Constraint" control the following
 * 1. Order sequence of instance which implements the interface of array.
 * 2. The output when the condition is meet in the instance by given the input type of T.
 *
 * @author skl
 * @since 2021-01-26
 *
 * @param <T>
 */
public interface Constraint<T>  {
    public int order();
    public String output();
    public boolean condition(T number);
}
