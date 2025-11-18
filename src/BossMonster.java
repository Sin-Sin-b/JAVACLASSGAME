public class BossMonster extends Monster {
    BossMonster(String name, String type, int attack, double hp, int level, int rewardExp) {
        super(name, type, attack, hp, level, rewardExp);


        System.out.println("!!! 강력한 보스의 기운이 느껴집니다 !!!");
    }

}
