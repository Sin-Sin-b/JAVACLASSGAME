import java.util.Scanner;
import java.util.Random;
public class Game {
    Player player;
    SkillList skilllist;
    ItemList itemlist;
    StageList stagelist;
    Scanner scanner = new Scanner(System.in);

    Game() {
        System.out.println("이름을 입력하십시오 : ");
        String name = scanner.next();
        this.player = new Player(name);
        this.skilllist = new SkillList();
        this.itemlist = new ItemList();
        this.stagelist = new StageList();
    }

    public void run() {
        System.out.println("게임에 오신 것을 환영합니다.");
        while (true) {
            System.out.println("\n🏕️ --- 야영지에 도착했습니다 --- 🏕️");
            System.out.println("무엇을 하시겠습니까?");
            System.out.println("1. 전투 스테이지로 이동");
            System.out.println("2. 상점 이용하기");
            System.out.println("3. 인벤토리 확인");
            System.out.println("4. 내 정보 보기");
            System.out.println("5. 스킬 정비");
            System.out.println("6. 게임 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    System.out.println("1. 4층 연구 개발 / 기획 / 디자인층 - 적정 레벨 1");
                    System.out.println("2. 5층 재무 / 회계층 - 적정 레벨 2");
                    System.out.println("3. 6층 인사 / 총무층 - 적정 레벨 3");
                    System.out.println("4. 7층 영업 / 마케팅층 - 적정 레벨 4");
                    System.out.println("5. 8층 임원층 - 적정 레벨 5");
                    System.out.println("6. 9층 대표이사 / 이사회층 - 적정 레벨 6");
                    System.out.println("어떤 스테이지로 가시겠습니까?");
                    int stagechoice = scanner.nextInt();
                    if (stagechoice == 1) {
                        stagelist.floor4();
                    } else if (stagechoice == 2) {
                        stagelist.floor5();
                    } else if (stagechoice == 3) {
                        stagelist.floor6();
                    } else if (stagechoice == 4) {
                        stagelist.floor7();
                    } else if (stagechoice == 5) {
                        stagelist.floor8();
                    } else {
                        stagelist.floor9();
                    }


                    break;
                case 2:


                    break;// Player 객체의 상태 표시 메소드 호출
                case 3:
                    player.showInventory();
                    System.out.println("무엇을 하시겠습니까?");
                    System.out.println("1. 야영지로 돌아간다.");
                    System.out.println("2. 게임을 종료한다.");
                    int choice3 = scanner.nextInt();
                    if (choice3 == 1) {
                        break;
                    } else {
                        System.out.println("게임을 종료합니다.");
                        return;
                    }

                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("게임을 종료합니다.");
                    return; // run 메소드를 끝내서 프로그램 종료
                default:
                    System.out.println("잘못된 입력입니다.");
            }


        }

    }


    void battleFloor4() {
        Stage battlestage = stagelist.floor4();
        System.out.println(battlestage.name + "에 입장 하셨습니다.");
        System.out.println(battlestage.description);
        System.out.println("입장 레벨 : " + battlestage.entryLevel);

        Monster monster1 = Monster.create("고블린 전사");
        Monster monster2 = Monster.create("고블린 궁수");

        System.out.println(monster1.name + "가 생성되었습니다.");
        System.out.println(monster2.name + "가 생성되었습니다.");


        Random random = new Random();

        while (player.hp > 0 && monster1.hp > 0 && monster2.hp > 0) {
            System.out.println("전투를 시작합니다");
            System.out.println("-- 플레이어턴 -- ");
            System.out.println("1. 공격");
            System.out.println("2. 아이템 사용");
            int battlechoice = scanner.nextInt();
            if (battlechoice == 1) {
                
            }


        }

        void openShop() {
            System.out.println("------ 상점 ------");
            System.out.println("1. 힘의 포션 구매 (10 골드)");
            System.out.println("2. 회복 포션 구매 (10 골드)");
            System.out.println("3. 상점 나가기");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            if (choice == 1) {

                Item strengthPotion = itemlist.getStrPotion();
                player.addItemToInventory(strengthPotion);
                // 3. 아이템 가격만큼 골드를 차감합니다 (이 기능은 나중에 추가).
                // player.gold -= strengthPotion.price;
            } else if (choice == 2) {
                Item healPotion = itemlist.getHealPotion();
                player.addItemToInventory(healPotion);
            }
        }

    }
}