import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int hp;
    int level;
    int attack;
    int experience;
    int needExperience;
    int gold;
    List<Item> inventory;

            Player(String name){
        this.name = name;
        this.level = 1;
        this.hp = 100;
        this.attack = 10;
        this.experience = 0;
        this.needExperience = 100;
        this.gold = 0;

        this.inventory = new ArrayList<>();
            }

    public void showStat() {
        System.out.println("------ 캐릭터 정보 ------");
        System.out.println("이름: " + name);
        System.out.println("레벨: " + level);
        System.out.println("체력: " + hp);
        System.out.println("공격력: " + attack);
        System.out.println("현재 경험치: " + experience);
        System.out.println("요구 경험치: " + (needExperience - experience));
        System.out.println("보유 골드: " + gold);

        System.out.println("------------------------");
    }

    int getAttack(){
    return attack;
    }

    void addItemToInventory(Item item) {
        System.out.println(item.name + "을(를) 획득했습니다.");
        this.inventory.add(item);
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
            this.hp += 30;

            System.out.println(" 레벨 업! ");
            System.out.println("레벨 " + this.level + "이 되었습니다.");
            showStat();
        }
    }


}

