public class DamageSkill extends Skill{

int damage;

    DamageSkill(String name, String description, String job,String category, int requiredLevel,int damage) {
        super(name, description, job,category,requiredLevel);
        this.damage = damage;
        this.type = "공격";
    }
    @Override
    public void execute(Player user, Monster target) {
        if (target != null) {

            int totalDamage = (int)(user.fightattack + this.damage);

            System.out.println(this.name + " 사용!");
            System.out.println("적에게 " + totalDamage + "의 데미지를 입혔습니다.");


            target.takeDamage(totalDamage);
        } else {
            System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
        }
    }


}
