public class Client  {

    public AbstractProductA createA(AbstractFactory factory){
        return factory.createProductA();
    };
    public AbstractProductB createB(AbstractFactory factory){
        return factory.createProductB();
    };
    
}
