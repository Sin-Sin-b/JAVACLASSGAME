public class UndeadLeader extends Monster {

    public UndeadLeader() {
        super("언데드 기사", "중간보스2", 55, 245, 5, 300);
    }

    @Override
    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("언데드 기사가 죽음의 숨결을 사용했다.");
                targetPlayer.takeDamage(this.attack + 10);
            } else {
                System.out.println("언데드 기사가 공간 베기를 사용했다.");
                targetPlayer.takeDamage(this.attack + 30);
            }
            System.out.println("--------------------");
        }
    }
}
