public class UndeadKing extends Monster {

    public UndeadKing() {
        super("언데드 왕", "보스", 70, 355, 6, 150);
    }

    @Override
    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("언데드 왕이 영원한 안식처를 사용했다.");
                targetPlayer.takeDamage(this.attack + 25);
            } else {
                System.out.println("언데드 왕이 파멸의 일격을 사용했다.");
                targetPlayer.takeDamage(this.attack + 50);
            }
            System.out.println("--------------------");
        }
    }
}
