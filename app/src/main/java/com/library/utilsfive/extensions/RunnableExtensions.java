package com.library.utilsfive.extensions;

/**
 * Created by Jan Rabe on 26/10/15.
 */
final public class RunnableExtensions {
    
    private RunnableExtensions()
        throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    
    public static void runSafely(final Runnable runnable) {
        try {
            runnable.run();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
