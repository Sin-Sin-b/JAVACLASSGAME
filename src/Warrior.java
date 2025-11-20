public class Warrior extends Player {
Warrior(String name){
super(name,"전사",100.0,10.0);
}




    public void useSkill(Skill skill, Monster target) {
        System.out.println(this.name + "이(가) " + skill.name + "을(를) 사용했습니다!");

        skill.execute(this,target);

        }
    }


