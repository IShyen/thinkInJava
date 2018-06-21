package com.sigar.think.c09.exercises;

class AbortedConstruction extends Exception {
    public AbortedConstruction() {
        super("Construction aborted");
    }
}

class WithCleanup {
    private boolean constructed = false;

    public WithCleanup(boolean abort) throws AbortedConstruction {
        // Perform construction that might be
        // unsucessful (and throw an exception) here.
        if(abort)
            throw new AbortedConstruction();
        System.out.println("After exception");
        constructed = true;
    }
    public void cleanup() {
        System.out.println("constructed = " + constructed);
        if(constructed)
            System.out.println("Cleaning up");
        else
            System.out.println("Constructor didn't finish, not cleaning up");
    }
}
public class E14_CleanupFlag {
    public static void main(String args[]) {
        WithCleanup wc = null;
        try {
            wc = new WithCleanup(false);
        } catch(AbortedConstruction e) {
            System.out.println("Caught " + e);
        } finally {
            System.out.println("In finally 1, preparing to clean up");
            wc.cleanup();
        }
        wc = null; // Very important!
        try {
            try {
                wc = new WithCleanup(true);
            } catch(AbortedConstruction e) {
                System.out.println("Caught " + e);
            } finally {
                System.out.println("In finally 2, preparing to clean up");
                wc.cleanup();
            }
        } catch(Exception e) {
            System.out.println("Caught exception "+ e);
        }
    }
}
