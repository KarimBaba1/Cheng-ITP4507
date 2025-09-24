public class Client {
    public void doAction() {
        System.out.println("Client: doAction");
        Server2 s = new Server2();     // as in Figure 1 (initial requirement)
        s.doService();
    }
}

