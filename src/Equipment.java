public class Equipment extends Item {

int addedHp;
Equipment(String name, String description, int price, int addedHp){
super(name,description,price,"방어구");
this.addedHp = addedHp;
}

}
