package com.siggemannen.functional.throwing;

import org.junit.Test;

/**
 * Verifies {@link ThrowingRunnable}
 */
public class ThrowingRunnableTest
{
    @Test(expected = Exception.class)
    public void test_runnable_exception()
    {
        Runnable tr = new FailureThrowingRunnable();
        tr.run();
    }

    @Test
    public void test_ok()
    {
        Runnable tr = new OKThrowingRunnable();
        tr.run();
    }

    @Test(expected = Exception.class)
    public void test_throwing_runnable()
    {
        ThrowingRunnable tr = this::runThis;
        tr.run();
    }

    private void runThis() throws Exception
    {
        throw new Exception();
    }

    class FailureThrowingRunnable implements ThrowingRunnable
    {

        @Override
        public void run0() throws Throwable
        {
            throw new Exception();
        }
    }

    class OKThrowingRunnable implements ThrowingRunnable
    {

        @Override
        public void run0() throws Throwable
        {
        }
    }
}
