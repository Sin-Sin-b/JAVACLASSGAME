import java.util.ArrayList;

public class Blacksmith extends Npc{

Blacksmith(){
super("대장장이 스미스");

}
    public void devilStoneUseWarrior(Game game) {

        System.out.println("\n--- " + this.name + " ---");
        System.out.println("자네가 가진 마석을 보여주게. 잠재력을 개방해 줄 수 있을지도 모르지...");
        game.player.showDevilstone();

        ArrayList<Item> usabledevilstones = new ArrayList<>();
        for (Item item : game.player.devilstone) {
            if (item.type.equals("1차강화석") || item.type.equals("2차강화석")) {
                usabledevilstones.add(item);
            }
        }

        if (usabledevilstones.isEmpty()) {
            System.out.println(this.name + ": 쓸만한 마석이 없군. 더 구해오게.");
            return;
        }

        System.out.println("------ 사용할 아이템 선택 ------");
        for (int i = 0; i < usabledevilstones.size(); i++) {
            Item item = usabledevilstones.get(i);
            System.out.println((i + 1) + ". " + item.name);
        }
        System.out.println("0. 취소");
        System.out.print("선택: ");

        int choice = game.scanner.nextInt();

        if (choice > 0 && choice <= usabledevilstones.size()) {
            Item selecteditem = usabledevilstones.get(choice - 1);
            if (selecteditem.type.equals("1차강화석")) {

                game.player.addSkill(game.skilllist.ruinousWave());
                game.player.devilstone.remove(selecteditem);
                System.out.println(this.name + ": 훌륭하군! '파멸의 검기'의 힘일세.");

            } else {
                game.player.addSkill(game.skilllist.demonic());
                game.player.devilstone.remove(selecteditem);
                System.out.println(this.name + ": 조심하게! '마신화'의 힘은 강력하지만 위험하다네.");
            }
        } else {
            System.out.println(this.name + ": 현명한 선택일세.");
        }
    }
}
