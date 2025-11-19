public class DamageSkill {

int damage;
String type;
    DamageSkill(String name, String description, String job,String category, int requiredLevel,int damage) {
        super(name, description, job,category,requiredLevel);
        this.damage = damage;
        this.type = "공격";
    }

}
