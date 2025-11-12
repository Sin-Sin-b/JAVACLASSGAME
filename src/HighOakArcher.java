public class HighOakArcher extends Monster {

    public HighOakArcher() {
        super("하이오크 궁수", "일반", 20, 35, 2, 75);
    }


    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("하이오크 궁수가 화살비를 사용했다.");
                targetPlayer.takeDamage(this.attack);
            } else {
                System.out.println("하이오크 궁수가 포인트 샷을 사용했다.");
                targetPlayer.takeDamage(this.attack + 15);
            }
            System.out.println("--------------------");
        }
    }
}
