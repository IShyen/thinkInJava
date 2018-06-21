package com.sigar.think.c06;

/**
 * It looks like you can override a private or private final method.
 * Only looks like.
 */
class WithFianls{
    // Identical to "private" alone:
    private final void f(){
        System.out.println("WithFinals.f()");
    }

    // Also automatically "final":
    private void g(){
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFianls{
    private final void f(){
        System.out.println("Overriding Private.f()");
    }

    private void g(){
        System.out.println("Overriding Private.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate{
    public final void f(){
        System.out.println("Overriding Private2.f()");
    }

    public final void g(){
        System.out.println("Overriding Private2.g()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args){
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods
//         op.f();
//         op.g();
        // Same here:
        WithFianls wf = op2;
        // wf.f();
        // wf.g();
    }
}
