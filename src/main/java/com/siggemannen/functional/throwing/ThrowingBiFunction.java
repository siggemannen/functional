package com.siggemannen.functional.throwing;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Throwing function version of {@link Function}
 */
public interface ThrowingBiFunction<T, O, R> extends BiFunction<T, O, R>
{
    /**
     * The actual method that performs work
     * 
     * @param t argument to function
     * @return applied value
     * @throws Throwable exception that can be thrown from the function
     */
    R apply0(T t, O o) throws Throwable;


    /**
     * Implementation that "sneaks" in exception handling and re-throws exceptions from apply0 method, shouldn't be overridden
     */
    @Override
    default R apply(T t, O o)
    {
        try
        {
            return apply0(t, o);
        }
        catch (Throwable ex)
        {
            Throwing.sneakyThrow(ex);
        }
        return null;
    }
}
