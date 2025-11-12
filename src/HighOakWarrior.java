public class HighOakWarrior extends Monster {

    public HighOakWarrior() {
        super("하이오크 전사", "일반", 15, 55, 2, 75);
    }
    @Override
    public void attackPlayer(Player targetPlayer) {
        if (this.hp > 0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);
            if (pattern == 0) {
                System.out.println("하이오크 전사가 내려치기를 사용했다.");
                targetPlayer.takeDamage(this.attack);
            } else {
                System.out.println("하이오크 전사가 휠 윈드를 사용했다.");
                targetPlayer.takeDamage(this.attack + 15);
            }
            System.out.println("--------------------");
        }
    }
}
