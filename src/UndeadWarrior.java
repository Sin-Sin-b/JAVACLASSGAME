public class UndeadWarrior extends Monster {

    public UndeadWarrior() {
        super("언데드 검사", "일반", 25, 115, 4, 125);
    }

@Override
    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("언데드 검사가 벼락검을 사용했다.");
                targetPlayer.takeDamage(this.attack);
            } else {
                System.out.println("언데드 검사가 검기를 사용했다.");
                targetPlayer.takeDamage(this.attack + 20);
            }
            System.out.println("--------------------");
        }
    }
}