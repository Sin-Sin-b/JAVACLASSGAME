public class Shopkeeper extends Npc {

    Shopkeeper() {
        super("상점주인 키리의 잔영");
    }

    void openShop(Game game) {


        while (true) {
            System.out.println("\n--- " + this.name + " ---");
            System.out.println("어서오게나. 필요한 게 있나?");
            System.out.println("------ 상점 ------");
            System.out.println("보유골드 : " + game.player.gold);
            System.out.println("1. 힘의 포션 구매 (10 골드)");
            System.out.println("2. 회복 포션 구매 (10 골드)");
            System.out.println("3. 상급 힘의 포션 구매 (30 골드)");
            System.out.println("4. 상급 회복 포션 구매 (30 골드)");
            System.out.println("3. 상점 나가기");
            System.out.print("선택: ");

            int choice = game.scanner.nextInt();

            if (choice == 1) {
                if (game.player.gold >= 10) {
                    Item strengthPotion = game.itemlist.getStrPotion();
                    game.player.addItemToInventory(strengthPotion);
                    game.player.usegold(10);
                } else {
                    System.out.println("골드가 부족합니다.");
                }


            } else if (choice == 2) {
                if (game.player.gold >= 10) {
                    Item healPotion = game.itemlist.getHealPotion();
                    game.player.addItemToInventory(healPotion);
                    game.player.usegold(10);
                } else {
                    System.out.println("골드가 부족합니다.");
                }
            } else if (choice == 3) {
                if (game.player.gold >= 30) {
                    Item higherStrengthPotion = game.itemlist.getHIgherStrPotion();
                    game.player.addItemToInventory(higherStrengthPotion);
                    game.player.usegold(30);
                } else if (choice == 4) {
                    if (game.player.gold >= 30) {
                        Item higherHealPotion = game.itemlist.getHigherHealPotion();
                        game.player.addItemToInventory(higherHealPotion);
                        game.player.usegold(30);
                    } else {
                        System.out.println("골드가 부족합니다.");
                    }

                } else {
                    System.out.println(this.name + ": 또 들르게나.");
                    break;
                }
            }
        }
    }
}