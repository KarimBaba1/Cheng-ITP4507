class Memento {
    MyClass myClass;   // package-protected
    private int mState;

    public Memento(MyClass mc) {
        myClass = mc;
        mState = mc.getState();
    }

    public void restore() {
        myClass.setState(mState);
    }
}

