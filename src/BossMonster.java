public class BossMonster extends Monster {
    BossMonster(String name, String type, int attack, double hp, int level, int rewardExp) {
        super(name, type, attack, hp, level, rewardExp);


        System.out.println("!!! 강력한 보스의 기운이 느껴집니다 !!!");
    }

    @Override
    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 --");

            if (!Monsterskills.isEmpty()) {

                int randomN = random.nextInt(Monsterskills.size());
                MonsterSkill skill = Monsterskills.get(randomN);


                System.out.println(this.name + "이(가) " + skill.name + "을(를) 사용했다!");
                targetPlayer.takeDamage(this.attack + skill.bonusDamage);
            } else {

                System.out.println(this.name + "이(가) 공격했다.");
                targetPlayer.takeDamage(this.attack);
            }
            System.out.println("--------------------");
        }
    }

}
