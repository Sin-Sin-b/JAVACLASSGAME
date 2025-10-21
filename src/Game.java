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
        player.addcut(skilllist.cut());
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

                    System.out.println("1. 4층 개발층 - 적정 레벨 1");
                    System.out.println("2. 5층 회계층 - 적정 레벨 2");
                    System.out.println("3. 6층 인사층 - 적정 레벨 3");
                    System.out.println("4. 7층 마케팅층 - 적정 레벨 4");
                    System.out.println("5. 8층 임원층 - 적정 레벨 5");
                    System.out.println("6. 9층 대표이사 / 이사회층 - 적정 레벨 6");
                    System.out.println("어떤 스테이지로 가시겠습니까?");
                    int stagechoice = scanner.nextInt();
                    if (stagechoice == 1) {
                        stagelist.floor4();
                        battleFloor4();
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
                openShop();

                    break;// Player 객체의 상태 표시 메소드 호출
                case 3:
                    player.showInventory();
                    System.out.println("무엇을 하시겠습니까?");
                    System.out.println("1. 야영지로 돌아간다.");
                    System.out.println("2. 게임을 종료한다.");
                    int choice3 = scanner.nextInt();
                    if (choice3 == 2)  {
                        System.out.println("게임을 종료합니다.");
                        return;
                    }
                    break;

                case 4:
                    break;
                case 5:
                player.showSKill();
                    System.out.println("무엇을 하시겠습니까?");
                    System.out.println("1. 야영지로 돌아간다");
                    System.out.println("2. 장착 스킬 목록을 정비한다.");
                    int choice5 = scanner.nextInt();
                    if (choice5==1){
                    break;

                    }
                    else{

                    }

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
        System.out.println();
        System.out.println("입장 레벨 : " + battlestage.entryLevel);
        System.out.println();
        System.out.println("======================================");
        if (player.level < battlestage.entryLevel) {

            System.out.println("적정 레벨이 아닙니다. 야영지로 돌아갑니다.");


        } else {
            System.out.println();
            Monster monster1 = Monster.create("고블린 전사");
            Monster monster2 = Monster.create("고블린 궁수");

            System.out.println(monster1.name + "가 생성되었습니다.");
            System.out.println(monster2.name + "가 생성되었습니다.");


            Random random = new Random();

            while (player.hp > 0 && monster1.hp > 0 && monster2.hp > 0) {
                System.out.println("전투를 시작합니다");
                System.out.println("플레이어의 체력 : " + player.hp);
                System.out.println("고블린 전사의 체력 : " + monster1.hp);
                System.out.println("고블린 궁수의 체력 : " + monster2.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");

                int battlechoice = scanner.nextInt();
                if (battlechoice == 1) {
                    System.out.println("누구를 공격하시겠습니까?");
                    System.out.println("1. 고블린 전사");
                    System.out.println("2. 고블린 궁수");
                    int battlechoice2 = scanner.nextInt();
                    if (battlechoice2==1){
                       monster1.hp-=player.attack;
                        System.out.println("일반 공격으로" + player.attack + " 데미지를 주었습니다.");

                    }
                    else{
                        monster2.hp-=player.attack;
                        System.out.println("일반 공격으로" + player.attack + " 데미지를 주었습니다.");
                    }
                }
            }

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


            }
            else if (choice == 2) {
                Item healPotion = itemlist.getHealPotion();
                player.addItemToInventory(healPotion);
            }
        }

    }
