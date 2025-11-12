public class GoblinArcher extends Monster {

    GoblinArcher() {
        super("고블린 궁수", "일반", 15, 20, 1, 50);
    }

    void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("-- " + this.name + "의 턴 --");

            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("고블린 궁수가 속사를 사용했다.");
                targetPlayer.takeDamage(this.attack);
            } else {
                System.out.println("고블린 궁수가 헤드샷을 사용했다.");
                targetPlayer.takeDamage(this.attack + 10);
            }
            System.out.println("--------------------");
        }
    }
}