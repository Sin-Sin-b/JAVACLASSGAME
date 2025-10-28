import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game {
    Player player;
    SkillList skilllist;
    ItemList itemlist;
    StageList stagelist;
    Scanner scanner = new Scanner(System.in);
    Skill selectSkill;

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

            while (player.fighthp > 0) {
                System.out.println("전투를 시작합니다");
                System.out.println("플레이어의 체력 : " + player.fighthp);
                System.out.println("고블린 전사의 체력 : " + monster1.hp);
                System.out.println("고블린 궁수의 체력 : " + monster2.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");
                System.out.println("선택 : ");

                int battlechoice = scanner.nextInt();

                if (battlechoice == 1) {
                    System.out.println("누구를 공격하시겠습니까?");
                    System.out.println("1. 고블린 전사");
                    System.out.println("2. 고블린 궁수");
                    System.out.println("선택 : ");
                    int monsterchoice = scanner.nextInt();
                    while (true){
                        if (monsterchoice == 1) {
                            monster1.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");
                            break;
                        } else if (monsterchoice == 2) {
                            monster2.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");
                            break;
                        } else {
                            System.out.println("없는 몬스터 입니다.올바른 번호를 입력해주세요.");
                        }
                }
                }


                    else if (battlechoice == 2) {
                    player.showSKill();
                    System.out.println("몇번 스킬을 사용하시겠습니까?");
                    int skillchoice = scanner.nextInt();
                    while (true){
                        if (skillchoice == 1) {
                            System.out.println("누구를 공격하시겠습니까?");
                            System.out.println("1. 고블린 전사");
                            System.out.println("2. 고블린 궁수");
                            System.out.println("선택 : ");
                            int monsterchoice = scanner.nextInt();
                            while (true){
                            if (monsterchoice == 1) {
                                selectSkill = player.getskill(1);
                                monster1.hp -= player.fightattack + selectSkill.damage;
                                System.out.println(selectSkill.name + "를 사용했습니다.");
                                System.out.println("고블린 전사에게 " + player.attack + selectSkill.damage + "의 데미지를 주었습니다.");
                                break;
                            } else if (monsterchoice == 2) {
                                selectSkill = player.getskill(1);
                                monster2.hp -= player.fightattack + selectSkill.damage;
                                System.out.println(selectSkill.name + "를 사용했습니다.");
                                System.out.println("고블린 전사에게 " + player.attack + selectSkill.damage + "의 데미지를 주었습니다.");
                                break;
                            }
                            else {
                                System.out.println("없는 몬스터 입니다.올바른 번호를 입력해주세요.");
                            }
                            }

                        } else {
                            System.out.println("스킬 목록에 없는 번호입니다. 다시 선택해주세요.");
                        }
                }

                    }
                    else{
                        ArrayList<Item> usableItems = new ArrayList<>();
                        for (Item item:player.inventory){
                            if(item.type.equals("회복")||item.type.equals("강화")){
                                usableItems.add(item);
                            }
                        }

                        System.out.println("------ 아이템 ------");
                        for(int i = 1;i<=usableItems.size();i++){
                            Item item = usableItems.get(i-1);

                            System.out.println(i+  ". " + item.name + ": " + item.description);

                        }
                        System.out.println("--------------------");


                    System.out.println("어떤 아이템을 사용하시겠습니까?");
                    boolean use = true;

                        while(use){
                            System.out.println("선택 : ");
                            int battlechoice3 = scanner.nextInt();

                         if (battlechoice3>usableItems.size()){
                             System.out.println("--------------------");
                             System.out.println("다시 입력해 주십시오.");
                             System.out.println("선택 : ");
                         }
                         else {
                            Item select = usableItems.get(battlechoice3-1);

                            if (select.type.equals("강화"))
                            {
                            player.useStrongPotion();
                                System.out.println("플레이어의 현재 공격력이 " + player.fightattack + "가 되었습니다.");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }
                            else{
                                player.useHpPotion();
                                System.out.println("플레이어의 현재 체력이 " + player.fighthp + "가 되었습니다.");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }

                         }
                        }



                }


            }

        }
    }


    }
