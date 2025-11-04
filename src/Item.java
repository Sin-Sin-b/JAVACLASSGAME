public class Item {
    String name;
    String description;
    int price;
    String type;
    double attackMultiplier;
    int addedHp;
    double healedHp;

 Item(String name,String description,int price, String type,double attackMultiplier,int addedHp,double healedHp){
    this.name = name;
    this.description = description;
    this.price = price;
    this.type = type;
    this.attackMultiplier = attackMultiplier;
    this.addedHp = addedHp;
    this.healedHp = healedHp;
 }
}
