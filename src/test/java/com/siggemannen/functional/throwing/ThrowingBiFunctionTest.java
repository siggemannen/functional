package com.siggemannen.functional.throwing;

import java.util.function.BiFunction;

import org.junit.Test;

/**
 * Verifies {@link ThrowingSupplier}
 */
public class ThrowingBiFunctionTest
{
    @Test(expected = Exception.class)
    public void test_throwing_supplier_exception()
    {
        BiFunction<String, String, Integer> s = new FailureThrowingBiFunction<>();
        s.apply("testFailed", "");
    }

    @Test
    public void test_throwing_supplier_ok()
    {
        BiFunction<String, String, Integer> s = new OKThrowingBiFunction<>();
        s.apply("testOK", "");
    }

    @Test(expected = Exception.class)
    public void test_throwing_supplier_throws_method_error()
    {
        ThrowingBiFunction<Integer, String, String> s = this::throwingBiFunction;
        s.apply(5, "test");
    }

    private String throwingBiFunction(@SuppressWarnings("unused") int arg, @SuppressWarnings("unused") String option) throws Exception
    {
        throw new Exception();
    }

    class FailureThrowingBiFunction<T, O,  R> implements ThrowingBiFunction<T, O, R>
    {
        @Override
        public R apply0(T arg, O o) throws Throwable
        {
            throw new Exception();
        }
    }

    class OKThrowingBiFunction<T, O, R> implements ThrowingBiFunction<T, O, R>
    {
        @Override
        public R apply0(T arg, O o) throws Throwable
        {
            return null;
        }
    }
}
