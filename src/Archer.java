public class Archer extends Player{

    public Archer(String name) {
        super(name, "궁수", 90.0, 15.0);
    }

    public void useSkill(Skill skill, Monster target) {
        System.out.println(this.name + "이(가) " + skill.name + "을(를) 사용했습니다!");

        skill.execute(this,target);

    }
}
