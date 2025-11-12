public class UndeadMagician extends Monster {

    public UndeadMagician() {
        super("언데드 마법사", "일반", 30, 75, 4, 125);
    }

    @Override
    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("언데드 마법사가 전격을 사용했다.");
                targetPlayer.takeDamage(this.attack);
            } else {
                System.out.println("언데드 마법사가 에너지 볼트을 사용했다.");
                targetPlayer.takeDamage(this.attack + 20);
            }
            System.out.println("--------------------");
        }
    }
}