package pdp3;

abstract public class Tactic {//Soyut yöntem sadece soyut sınıflarda bulunabilir. Soyut sınıflardan nesne oluşturulamaz

    String name;

    public Tactic(String name){
        this.name =  name;
    }
    public abstract void war();// Soyut yöntem. Gerçekleme kısmı yoktur. Soyut sınıflarda bulunur.

    public  void  setName(String name1){this.name = name1;}


    public abstract void war(Colony colony1, Colony colony2);


}
