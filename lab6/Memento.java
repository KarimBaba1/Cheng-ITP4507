class Memento {
    MyClass myClass;  // package-protected (no modifier)
    private int mState;

    public Memento(MyClass mc) {
        myClass = mc;
        mState = mc.getState();
    }

    public void restore() {
        try {
            // Use reflection to directly modify private field 'state' of MyClass
            java.lang.reflect.Field field = MyClass.class.getDeclaredField("state");
            field.setAccessible(true);
            field.setInt(myClass, mState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

