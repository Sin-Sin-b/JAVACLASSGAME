public class Player {
    String name;
    int hp;
    int level;
    int attack;

            Player(String name){
        this.name = name;
        this.level = 1;
        this.hp = 100;
        this.attack = 10;
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

