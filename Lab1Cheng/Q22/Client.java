public class Client{

    public void doAction(){
        ServerInterface si = new Server();
        System.out.println("Client: do action");
        si.doService();

    }
}
