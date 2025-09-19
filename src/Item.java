public class Item {
    String name;
    String description;
    int price;
    String type;
    double getAttack;
    int getHp;
    double healHp;

 Item(String name,String description,int price, String type,double getAttack,int getHp,double healHp){
    this.name = name;
    this.description = description;
    this.price = price;
    this.type = type;
    this.getAttack = getAttack;
    this.getHp = getHp;
    this.healHp = healHp;
 }
}
