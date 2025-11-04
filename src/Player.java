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
    int devilswordLevel;
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
       this.devilswordLevel = 0;

        this.inventory = new ArrayList<>();
        this.skillset = new ArrayList<>();
        this.devilstone = new ArrayList<>();

            }
    void takeDamage(int damage) {
        this.fighthp -= damage;
        System.out.println(this.name + "에게 " + damage + "데미지를 주었다.");

        if (this.fighthp <= 0) {
            this.fighthp = 0;
            System.out.println("플레이어의 hp가 0이 되어 쓰러졌습니다. 야영지로 돌아갑니다.");
        }
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
                this.fighthp -= this.fullhp * 0.1;
                System.out.println("체력이 10% 감소해 " + this.fighthp + "이(가) 되었습니다.");
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

    void showStat() {
        System.out.println("------ 캐릭터 정보 ------");
        System.out.println("이름: " + name);
        System.out.println("레벨: " + level);
        System.out.println("체력: " + fullhp);
        System.out.println("공격력: " + attack);
        System.out.println("현재 경험치: " + experience);
        System.out.println("요구 경험치: " + (needExperience - experience));
        System.out.println("보유 골드: " + gold);
        System.out.println("마검 강화: " +  devilswordLevel + "단계" );

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
        System.out.println("★ " + item.name + "을(를) 획득했습니다. ★");
        this.devilstone.add(item);
    }

    void addcut(Skill skill){
        this.skillset.add(skill);

    }
    void usegold(int money){

       gold -= money;

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

