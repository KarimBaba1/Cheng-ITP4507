public class Cal {
    private Debug debugger;   // dependency injection

    public Cal(Debug debugger) {
        this.debugger = debugger;
    }

    public void compute() {
        int x = 2, y = 3;
        String s = "hello";

        debugger.log("Cal: compute()");
        int n = method1(x, y);
        int m = method2(s);
        debugger.log("method1(" + x + "," + y + ")=" + n);
        debugger.log("method2(" + s + ")=" + m);
    }

    int method1(int x, int y) {
        debugger.log("Cal: method1(" + x + "," + y + ")");
        return x + method3(y);
    }

    int method3(int y) {
        debugger.log("Cal: method3(" + y + ")");
        return 2 * y;
    }

    int method2(String s) {
        debugger.log("Cal: method2(" + s + ")");
        return s.length() - 2;
    }
}

