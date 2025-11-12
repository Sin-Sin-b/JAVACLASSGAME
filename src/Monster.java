import java.util.Random;

public abstract class Monster extends Character {
    String name;
    String type;
    int attack;
    double hp;
    int level;
    int rewardExp;
    Random random = new Random();

    Monster(String name, String type, int attack, int hp, int level, int rewardExp) {
        super(name,level,hp);
        this.type = type;
        this.attack = attack;
        this.rewardExp = rewardExp;
    }

    public abstract void attackPlayer(Player targetPlayer);

    void takeDamage(int damage) {
       super.takeDamage(damage);
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.name + "에게 " + damage + " 데미지를 주었습니다.");
            System.out.println(this.name + "이(가) 쓰러졌습니다.");
        } else {
            System.out.println(this.name + "에게 " + damage + " 데미지를 주었습니다.");
        }
    }


}
