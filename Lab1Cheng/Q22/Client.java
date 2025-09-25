public class Client{

    public void doAction(){
        ServerInterface si = new Server1();
        System.out.println("Client: do action");
        si.doService();

    }
}
