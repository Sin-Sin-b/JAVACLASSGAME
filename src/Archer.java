public class Archer extends Player{

    public Archer(String name) {
        super(name, "궁수", 90.0, 15.0);
    }

    public void useSkill(Skill skill, Monster target) {
        System.out.println(this.name + "이(가) " + skill.name + "을(를) 사용했습니다!");

        switch (skill.name) {
            case "더블샷":
                if (target != null) {

                    int damage = (int) ((this.fightattack + skill.damage) * 2);
                    System.out.println("화살 두 발이 연속으로 적중합니다!");
                    target.takeDamage(damage);
                } else {
                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "매의눈":

                this.fightattack = this.fightattack * 1.2;
                System.out.println("집중력이 높아져 공격력이 " + this.fightattack + "이(가) 되었습니다.");
                break;

            case "파워샷":
                if (target != null) {
                    int damage = (int) (this.fightattack + skill.damage);
                    System.out.println("강력한 화살이 적을 꿰뚫습니다!");
                    target.takeDamage(damage);
                } else {
                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "스나이프":
                if (target != null) {
                    int damage = (int) (this.fightattack + skill.damage);
                    System.out.println("적의 급소를 정확히 노렸습니다!");
                    target.takeDamage(damage);
                } else {
                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "공허의 화살":
                if (target != null) {
                    int damage = (int) (this.fightattack + skill.damage);
                    System.out.println("공허의 기운이 담긴 화살을 날립니다.");
                    target.takeDamage(damage);
                } else {
                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "심연의 눈":
                this.fightattack = this.fightattack * 2;
                System.out.println("심연을 들여다보며 공격력이 폭발적으로 증가해 " + this.fightattack + "이(가) 되었습니다.");
                break;

            default:
                System.out.println("알 수 없는 스킬입니다.");
                break;
        }
    }
}
