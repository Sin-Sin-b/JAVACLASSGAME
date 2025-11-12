public class Consumable extends Item {
    double attackMultiplier;
    double healedHp;

    Consumable(String name, String description, int price, String type, double attackMultiplier, double healedHp){

    super(name,description,price,type);
    this.attackMultiplier = attackMultiplier;
    this.healedHp = healedHp;

    }

}
