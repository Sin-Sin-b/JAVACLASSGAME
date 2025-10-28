import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    double fullhp;
    double fighthp;
    int level;
    double attack;
    double fightattack;
    int experience;
    int needExperience;
    int gold;
    List<Item> inventory;
    List<Skill> skillset;

            Player(String name){
        this.name = name;
        this.level = 1;
        this.fighthp = fullhp;
        this.fullhp = 100;
        this.attack = 10;
        this.fightattack = attack;
        this.experience = 0;
        this.needExperience = 100;
        this.gold = 0;

        this.inventory = new ArrayList<>();
        this.skillset = new ArrayList<>();

            }

    public void showStat() {
        System.out.println("------ 캐릭터 정보 ------");
        System.out.println("이름: " + name);
        System.out.println("레벨: " + level);
        System.out.println("체력: " + fullhp);
        System.out.println("공격력: " + attack);
        System.out.println("현재 경험치: " + experience);
        System.out.println("요구 경험치: " + (needExperience - experience));
        System.out.println("보유 골드: " + gold);

        System.out.println("------------------------");
    }


    void addItemToInventory(Item item) {
        System.out.println(item.name + "을(를) 획득했습니다.");
        this.inventory.add(item);
    }

    void addcut(Skill skill){
        this.skillset.add(skill);

    }


    void addSkill(Skill skill){
            System.out.println("새로운 스킬 [" + skill.name + "]을(를) 배웠습니다!");
            this.skillset.add(skill);

    }

    void showSKill(){
        System.out.println("------ 스킬 ------");
        for(int i = 1;i<=skillset.size();i++){
        Skill skill = skillset.get(i-1);
        System.out.println(i+". " + skill.name + ": " + skill.description);

        }
        System.out.println("--------------------");
    }

    void showInventory() {
        System.out.println("------ 인벤토리 ------");
        if (inventory.isEmpty()) {
            System.out.println("인벤토리가 비어있습니다.");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.name + ": " + item.description);
            }
        }
        System.out.println("--------------------");
    }


        void useStrongPotion(){

this.fightattack = this.fightattack * 1.1;

}

void useHpPotion(){
this.fighthp += this.fullhp*0.2;
}

    void getExperience(int exp) {
        this.experience += exp;
        System.out.println(exp + "의 경험치를 획득했습니다. (현재 경험치: " + this.experience + ")");


        if (this.experience >= this.needExperience) {
            levelUp();
        }
    }

    void levelUp() {

        while (this.experience >= this.needExperience) {
            this.level++;


            this.experience -= this.needExperience;


            this.needExperience +=50;


            this.attack += 5;
            this.fullhp += 30;

            System.out.println(" 레벨 업! ");
            System.out.println("레벨 " + this.level + "이 되었습니다.");
            showStat();
        }
    }

    Skill getskill(int number){

    return skillset.get(number-1);


    }


}

