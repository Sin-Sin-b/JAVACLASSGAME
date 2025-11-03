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
    Item equippedArmor;
    Item equippedHelmet;
    int devilsword;
    List<Item> inventory;
    List<Skill> skillset;
    List<Item> devilstone;

            Player(String name){
        this.name = name;
        this.level = 1;
        this.fullhp = 100;
        this.fighthp = fullhp;
        this.attack = 10;
        this.fightattack = attack;
        this.experience = 0;
        this.needExperience = 100;
        this.gold = 0;
        this.equippedArmor = null;
        this.equippedHelmet = null;
       this.devilsword = 0;

        this.inventory = new ArrayList<>();
        this.skillset = new ArrayList<>();
        this.devilstone = new ArrayList<>();

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
        System.out.println("마검 강화: " +  devilsword + "단계" );

        if(equippedArmor == null){
        System.out.println("장착 상의 : 없음");
        }else{
            System.out.println("장착 상의 : " + equippedArmor.name);
        }
        if(equippedHelmet== null){
            System.out.println("장착 투구 : 없음");
        }else{
            System.out.println("장착 투구 : " + equippedHelmet.name);
        }
        System.out.println("------------------------");
    }


    void addItemToInventory(Item item) {
        System.out.println(item.name + "을(를) 획득했습니다.");
        this.inventory.add(item);
    }

    void addItemToDevilstone(Item item){
        System.out.println(item.name + "을(를) 획득했습니다.");
        this.devilstone.add(item);
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

    void showDevilstone(){

        System.out.println("------ 마석 목록 ------");
        if (devilstone.isEmpty()){
            System.out.println("보유 마석이 없습니다.");
        }
        else{
            for (int i = 0; i < devilstone.size(); i++) {
                Item item = devilstone.get(i);

                System.out.println( (i + 1) + ". " + item.name + ": " + item.description);
            }
            System.out.println("--------------------");
        }


    }


        void useStrongPotion(){

this.fightattack = this.fightattack * 1.3;

}

void getGold(int gold){

this.gold += gold;

    System.out.println(this.gold + "골드를 획득했습니다.");

}

void useHpPotion(){
this.fighthp += this.fullhp*0.5;
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

