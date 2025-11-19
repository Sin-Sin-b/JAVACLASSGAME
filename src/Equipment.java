public class Equipment extends Item {

String job;
int addedHp;
Equipment(String name, String description, int price, int addedHp,String job){
super(name,description,price,"방어구");
this.addedHp = addedHp;
this.job = job;
}

}
