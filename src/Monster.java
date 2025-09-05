public class Monster {
    String name;
    int attack;
    int hp;
    int level;


    Monster(String name,int attack, int hp , int level) {
        this.name = name;
        this.attack = attack;
        this.hp = hp;
        this.level = level;
    }


    public void showStat() {
        System.out.println("------ 캐릭터 정보 ------");
        System.out.println("이름: " + name);
        System.out.println("레벨: " + level);
        System.out.println("체력: " + hp);
        System.out.println("공격력: " + attack);
        System.out.println("------------------------");
    }

}
