package pdp3;
abstract public class Production {

    String name;

    public Production(String name){
        this.name =  name;
    }
    public abstract void foodProduct();// Soyut yöntem. Gerçekleme kısmı yoktur. Soyut sınıflarda bulunur.

    public  String getName(){return  name;}

    public abstract void foodProduct(Colony colony);
}
