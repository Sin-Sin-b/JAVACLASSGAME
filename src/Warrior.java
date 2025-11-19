public class Warrior extends Player {

Warrior(String name){
super(name,"전사",100.0,10.0);
}

    public void useSkill(Skill skill, Monster target) {
        System.out.println(this.name + "이(가) " + skill.name + "을(를) 사용했습니다!");


        switch (skill.name) {
            case "횡베기":
                if (target != null) {
                    int damage = (int)(this.fightattack + skill.damage);
                    target.takeDamage(damage);
                } else {

                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "휠윈드":
                if (target != null) {
                    int damage = (int) (this.fightattack + skill.damage);
                    target.takeDamage(damage);
                } else {

                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "분쇄":
                if (target != null) {
                    int damage = (int)(this.fightattack + skill.damage);
                    target.takeDamage(damage);
                } else {

                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "파멸의 검기":

                if (target != null) {
                    int damage = (int)(this.fightattack + skill.damage);
                    target.takeDamage(damage);
                } else {

                    System.out.println("대상이 없어 스킬을 사용할 수 없습니다.");
                }
                break;

            case "광폭화":

                this.fightattack = this.fightattack * 1.3;
                this.hp -= this.fullhp * 0.1;
                System.out.println("체력이 10% 감소해 " + this.hp + "이(가) 되었습니다.");
                System.out.println("공격력이 30% 증가해" + this.fightattack + "이(가) 되었습니다.");
                break;

            case "마신화":

                this.fightattack = this.fightattack * 2;
                System.out.println("공격력이 100% 증가해" + this.fightattack + "이(가) 되었습니다.");
                break;

            default:
                System.out.println("알 수 없는 스킬입니다.");
                break;
        }
    }

}
