public class BossMonster extends Monster {
    BossMonster(String name, String type, int attack, double hp, int level, int rewardExp) {
        super(name, type, attack, hp, level, rewardExp);


        System.out.println("!!! 강력한 보스의 기운이 느껴집니다 !!!");
    }
    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 --");
            int pattern = random.nextInt(2);


            if (this.name.equals("하이오크 장군")) {
                if (pattern == 0) {
                    System.out.println("하이오크 장군이 내려치기를 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("하이오크 장군이 대지의 일격을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 30);
                }

            } else if (this.name.equals("언데드 기사")) {
                if (pattern == 0) {
                    System.out.println("언데드 기사가 죽음의 숨결을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 10);
                } else {
                    System.out.println("언데드 기사가 공간 베기를 사용했다.");
                    targetPlayer.takeDamage(this.attack + 30);
                }

            } else if (this.name.equals("언데드 왕")) {
                if (pattern == 0) {
                    System.out.println("언데드 왕이 영원한 안식처를 사용했다.");
                    targetPlayer.takeDamage(this.attack + 25);
                } else {
                    System.out.println("언데드 왕이 파멸의 일격을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 50);
                }
            }

            System.out.println("--------------------");
        }
    }

}
