public class HighOakLeader extends Monster {

    public HighOakLeader() {
        super("하이오크 장군", "중간보스", 40, 145, 3, 200);
    }


    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("하이오크 장군이 내려치기를 사용했다.");
                targetPlayer.takeDamage(this.attack);
            } else {
                System.out.println("하이오크 장군이 대지의 일격을 사용했다.");
                targetPlayer.takeDamage(this.attack + 30);
            }
            System.out.println("--------------------");
        }
    }
}