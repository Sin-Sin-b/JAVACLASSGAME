
 public class GoblinWarrior extends Monster {

     GoblinWarrior() {

         super("고블린전사", "일반", 10, 30, 1, 50);

     }

     void attackPlayer(Player targetPlayer) {
         if (this.hp > 0) {
             System.out.println("-- " + this.name + "의 턴 --");
             int pattern = random.nextInt(2);
             if (pattern == 0) {
                 System.out.println("고블린 전사가 방패치기를 사용했다.");
                 targetPlayer.takeDamage(this.attack);
             } else {
                 System.out.println("고블린 전사가 강타를 사용했다.");
                 targetPlayer.takeDamage(this.attack + 10);
             }
             System.out.println("--------------------");
         }
     }
 }