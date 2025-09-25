public abstract class Creator { // ITALIC always abstract
  public abstract Product factoryMethod();

  
  public void anOperation(){
    Product p = factoryMethod();
    System.out.println("Product Created: "+ p.getName());
  } 

}
