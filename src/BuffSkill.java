public class BuffSkill extends Skill{
double attackMultiplier;
String type;
   BuffSkill(String name, String description, String job,String category, int requiredLevel, double attackMultiplier) {
        super(name, description, job, category, requiredLevel);
        this.attackMultiplier = attackMultiplier;
         this.type = "버프";

    }

}

