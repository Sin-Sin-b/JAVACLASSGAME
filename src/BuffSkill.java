public class BuffSkill extends Skill{
double attackMultiplier;
String type;
   BuffSkill(String name, String description, String job,String category, int requiredLevel, double attackMultiplier) {
        super(name, description, job, category, requiredLevel);
        this.attackMultiplier = attackMultiplier;
         this.type = "버프";

    }
    void execute(Player user, Monster target) {

        double oldAttack = user.fightattack;


        user.fightattack = user.fightattack * this.attackMultiplier;

        System.out.println(this.name + " 발동!");
        System.out.println("공격력이 " + oldAttack + " -> " + user.fightattack + " 로 증가했습니다.");
    }
}

