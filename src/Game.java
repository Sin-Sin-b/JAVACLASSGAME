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
    Monsterlist monsterlist;

    Game() {
        System.out.println("이름을 입력하십시오 : ");
        String name = scanner.next();
        this.player = new Player(name);
        this.skilllist = new SkillList();
        this.itemlist = new ItemList();
        this.stagelist = new StageList();
        this.monsterlist = new Monsterlist();
        player.addcut(skilllist.cut());
    }

    public void run() {
        System.out.println("게임에 오신 것을 환영합니다.");
        while (true) {
            player.hp = player.fullhp;
            player.fightattack = player.attack;


            System.out.println("\n🏕️ --- 야영지에 도착했습니다 --- 🏕️");
            System.out.println("무엇을 하시겠습니까?");
            System.out.println("1. 전투 스테이지로 이동");
            System.out.println("2. 상점 이용하기");
            System.out.println("3. 인벤토리 확인");
            System.out.println("4. 내 정보 보기");
            System.out.println("5. 스킬 목록");
            System.out.println("6. 마검 강화");
            System.out.println("7. 게임 종료");
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

                    while(true) {
                        int stagechoice = scanner.nextInt();
                    if (stagechoice == 1) {
                        stagelist.floor4();
                        battleFloor4();
                        break;
                    } else if (stagechoice == 2) {
                        stagelist.floor5();
                        battleFloor5();
                        break;
                    } else if (stagechoice == 3) {
                        stagelist.floor6();
                        battleFloor6();
                        break;
                    } else if (stagechoice == 4) {
                        stagelist.floor7();
                        battleFloor7();
                        break;
                    } else if (stagechoice == 5) {
                        stagelist.floor8();
                        battleFloor8();
                        break;
                    } else if (stagechoice == 6) {
                        stagelist.floor9();
                        boolean clear = battleFloor9();
                        if (clear == true) {
                            return;
                        }
                        break;
                    } else{
                        System.out.println("올바른 스테이지 번호를 입력해 주십시오.");
                    }

                }
                    break;

                case 2:
                    openShop();

                    break;// Player 객체의 상태 표시 메소드 호출
                case 3:
                    player.showInventory();
                    System.out.println("무엇을 하시겠습니까?");
                    System.out.println("1. 야영지로 돌아간다.");
                    System.out.println("2. 아이템을 장착한다.");
                    int choice3 = scanner.nextInt();
                    if (choice3 == 2) {
                        equipItem();
                    } else {
                        System.out.println("야영지로 돌아갑니다.");
                        break;
                    }
                    break;

                case 4:
                    player.showStat();
                    break;
                case 5:
                    player.showSKill();
                    break;

                case 6:
                    System.out.println("사용할 마석을 골라주십시오.");
                    player.showDevilstone();
                    devilStoneUse();
                    break;

                case 7:
                    System.out.println("게임을 종료합니다.");
                    return; // run 메소드를 끝내서 프로그램 종료
                default:
                    System.out.println("잘못된 입력입니다.");
            }


        }

    }


    void openShop() {

        while (true) {
            System.out.println("------ 상점 ------");
            System.out.println("보유골드 : "+ player.gold );
            System.out.println("1. 힘의 포션 구매 (10 골드)");
            System.out.println("2. 회복 포션 구매 (10 골드)");
            System.out.println("3. 상점 나가기");
            System.out.print("선택: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                if (player.gold >= 10) {
                    Item strengthPotion = itemlist.getStrPotion();
                    player.addItemToInventory(strengthPotion);
                    player.usegold(10);
                } else {
                    System.out.println("골드가 부족합니다.");
                }


            } else if (choice == 2) {
                if (player.gold >= 10) {
                    Item healPotion = itemlist.getHealPotion();
                    player.addItemToInventory(healPotion);
                    player.usegold(10);
                } else {
                    System.out.println("골드가 부족합니다.");
                }
            } else {
                System.out.println("야영지로 돌아갑니다.");
                break;
            }
        }
    }

    void devilStoneUse() {

        ArrayList<Item> usabledevilstones = new ArrayList<>();
        for (Item item : player.devilstone) {

            if (item.type.equals("1차강화석") || item.type.equals("2차강화석")) {
                usabledevilstones.add(item);
            }
        }
        if (usabledevilstones.isEmpty()) {
            System.out.println("사용할 수 있는 마석이 없습니다.");
            return;
        }
        System.out.println("------ 사용할 아이템 선택 ------");
        for (int i = 0; i < usabledevilstones.size(); i++) {
            Item item = usabledevilstones.get(i);
            System.out.println((i + 1) + ". " + item.name);

        }
        System.out.println("0. 취소");
        System.out.print("선택: ");
        int choice = scanner.nextInt();

        if (choice > 0 && usabledevilstones.size() <= choice) {
            Item selecteditem = usabledevilstones.get(choice - 1);
            if (selecteditem.type.equals("1차강화석")) {

                player.addSkill(skilllist.ruinousWave());
                player.devilstone.remove(selecteditem);
                System.out.println("'파멸의 검기' 스킬을(를) 획득했습니다.");

            } else {

                player.addSkill(skilllist.demonic());
                player.devilstone.remove(selecteditem);
                System.out.println("'마신화' 스킬을(를) 획득했습니다.");
            }


        }

    }

    void equipItem() {

        ArrayList<Item> equippableItems = new ArrayList<>();
        for (Item item : player.inventory) {

            if (item.type.equals("방어구")) {
                equippableItems.add(item);

            }
        }


        if (equippableItems.isEmpty()) {
            System.out.println("인벤토리에 장착할 아이템이 없습니다.");
            return;
        }


        System.out.println("------ 장착할 아이템 선택 ------");
        for (int i = 0; i < equippableItems.size(); i++) {
            Item item = equippableItems.get(i);

            System.out.println((i + 1) + ". " + item.name + " (체력 +" + ((Equipment) item).addedHp + ")");
        }
        System.out.println("0. 취소");
        System.out.print("선택: ");

        int choice = scanner.nextInt();


        if (choice > 0 && choice <= equippableItems.size()) {

            Item selectedItem = equippableItems.get(choice - 1);


            if (selectedItem.name.contains("헬멧")) {
                unequipAndEquip(selectedItem, "helmet");
            } else if (selectedItem.name.contains("갑옷")) {
                unequipAndEquip(selectedItem, "armor");
            }


            player.hp = player.fullhp;

        } else {
            System.out.println("장착을 취소합니다. 야영지로 돌아갑니다.");
        }
    }


    void unequipAndEquip(Item newItem, String slot) {
        Item oldItem = null;


        if (slot.equals("helmet")) {
            oldItem = player.equippedHelmet;
        } else if (slot.equals("armor")) {
            oldItem = player.equippedArmor;
        }


        if (oldItem != null) {
            System.out.println(oldItem.name + "을(를) 장착 해제합니다.");

            player.fullhp -= ((Equipment) oldItem).addedHp;

            player.inventory.add(oldItem);
        }


        if (slot.equals("helmet")) {
            player.equippedHelmet = newItem;
        } else if (slot.equals("armor")) {
            player.equippedArmor = newItem;
        }


        player.fullhp += ((Equipment) newItem).addedHp;

        player.inventory.remove(newItem);

        System.out.println(newItem.name + "을(를) 장착했습니다.");
        player.showStat();
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
            Monster monster1 = monsterlist.goblinwarrior();
            Monster monster2 = monsterlist.goblinarcher();

            System.out.println(monster1.name + "가 생성되었습니다.");
            System.out.println(monster2.name + "가 생성되었습니다.");


            Random random = new Random();

            while (player.hp > 0) {
                System.out.println(player.name + "의 체력 : " + player.hp);
                System.out.println(monster1.name + "의 체력 : " + monster1.hp);
                System.out.println(monster2.name + "의 체력 : " + monster2.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");
                System.out.println("선택 : ");

                int battlechoice = scanner.nextInt();


                if (battlechoice == 1) {
                    System.out.println("누구를 공격하시겠습니까?");
                    System.out.println("1. " + monster1.name);
                    System.out.println("2. " + monster2.name);
                    System.out.println("선택 : ");
                    int monsterchoice = scanner.nextInt();
                    while (true) {
                        if (monsterchoice == 1) {
                            monster1.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                            if (monster1.hp <= 0) {
                                monster1.hp = 0;
                                System.out.println(monster1.name + "가 쓰러졌습니다.");
                            }


                            break;
                        } else if (monsterchoice == 2) {
                            monster2.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                            if (monster2.hp <= 0) {
                                monster2.hp = 0;
                                System.out.println(monster2.name + "가 쓰러졌습니다.");
                            }
                            break;
                        } else {
                            System.out.println("없는 몬스터 입니다.올바른 번호를 입력해주세요.");
                            monsterchoice = scanner.nextInt();
                        }
                    }
                } else if (battlechoice == 2) {
                    player.showSKill();
                    System.out.println("몇번 스킬을 사용하시겠습니까?");
                    while (true) {
                        int skillchoice = scanner.nextInt();


                        if (skillchoice > 0 && skillchoice <= player.skillset.size()) {


                            Skill selectedSkill = player.getskill(skillchoice);

                            if (selectedSkill.damage > 0) {
                                System.out.println("누구를 공격하시겠습니까?");
                                System.out.println("1. "+ monster1.name);
                                System.out.println("2. "+ monster2.name);
                                System.out.println("선택 : ");
                                int monsterchoice = scanner.nextInt();

                                Monster targetMonster = null;
                                if(monsterchoice == 1) {
                                    targetMonster = monster1;
                                } else if (monsterchoice == 2) {
                                    targetMonster = monster2;
                                }
                                player.useSkill(selectedSkill, targetMonster);

                            } else {

                                player.useSkill(selectedSkill, null);
                            }

                            break;

                        } else {

                            System.out.println("스킬 목록에 없는 번호입니다. 다시 선택해주세요.");
                        }
                    }

                } else {
                    ArrayList<Item> usableItems = new ArrayList<>();
                    for (Item item : player.inventory) {
                        if (item.type.equals("회복") || item.type.equals("강화")) {
                            usableItems.add(item);
                        }
                    }

                    System.out.println("------ 아이템 ------");
                    for (int i = 1; i <= usableItems.size(); i++) {
                        Item item = usableItems.get(i - 1);

                        System.out.println(i + ". " + item.name + ": " + item.description);

                    }
                    System.out.println("--------------------");

                    if (usableItems.isEmpty()) {
                        System.out.println();
                        System.out.println("목록이 비어있어 사용할 아이템이 없습니다. 전투 선택지로 돌아갑니다.");
                        continue;
                    }


                    System.out.println("어떤 아이템을 사용하시겠습니까?");
                    boolean use = true;
                    System.out.println("선택 : ");
                    while (use) {


                        int battlechoice3 = scanner.nextInt();

                        if (battlechoice3 > usableItems.size()) {
                            System.out.println("--------------------");
                            System.out.println("다시 입력해 주십시오.");
                            System.out.println("--------------------");
                        } else {
                            Item select = usableItems.get(battlechoice3 - 1);

                            if (select.type.equals("강화")) {
                                player.useStrongPotion();
                                System.out.println("플레이어의 현재 공격력이 " + player.fightattack + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            } else {
                                player.useHpPotion();
                                System.out.println("플레이어의 현재 체력이 " + player.hp + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }

                        }
                    }


                }
                monster1.attackPlayer(player);


                if (player.hp > 0) {
                    monster2.attackPlayer(player);
                }


                if (player.hp <= 0) {
                    break;
                }

                if (monster1.hp == 0 && monster2.hp == 0) {
                    System.out.println("적을 모두 처치했습니다.");
                    int rewardexp = monster1.rewardExp + monster2.rewardExp;
                    player.addItemToInventory(itemlist.getLeatherArmor());
                    player.getGold(100);
                    player.getExperience(rewardexp);
                    player.levelUp();
                    player.addSkill(skilllist.berserk());


                    break;
                }


            }

        }
    }

    void battleFloor5() {
        Stage battlestage = stagelist.floor5();
        System.out.println(battlestage.name + "에 입장 하셨습니다.");
        System.out.println();
        System.out.println("입장 레벨 : " + battlestage.entryLevel);
        System.out.println();
        System.out.println("======================================");
        if (player.level < battlestage.entryLevel) {

            System.out.println("적정 레벨이 아닙니다. 야영지로 돌아갑니다.");


        } else {
            System.out.println();
            Monster monster1 = monsterlist.highoakwarrior();
            Monster monster2 = monsterlist.highoakarcher();

            System.out.println(monster1.name + "가 생성되었습니다.");
            System.out.println(monster2.name + "가 생성되었습니다.");


            Random random = new Random();

            while (player.hp > 0) {
                System.out.println("플레이어의 체력 : " + player.hp);
                System.out.println(monster1.name + "의 체력 : " + monster1.hp);
                System.out.println(monster2.name + "의 체력 : " + monster2.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");
                System.out.println("선택 : ");

                int battlechoice = scanner.nextInt();


                if (battlechoice == 1) {
                    System.out.println("누구를 공격하시겠습니까?");
                    System.out.println("1. "+monster1.name);
                    System.out.println("2. "+monster2.name);
                    System.out.println("선택 : ");
                    int monsterchoice = scanner.nextInt();
                    while (true) {
                        if (monsterchoice == 1) {
                            monster1.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                            if (monster1.hp <= 0) {
                                monster1.hp = 0;
                                System.out.println(monster1.name+"가 쓰러졌습니다.");
                            }


                            break;
                        } else if (monsterchoice == 2) {
                            monster2.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                            if (monster2.hp <= 0) {
                                monster2.hp = 0;
                                System.out.println(monster2.name + "가 쓰러졌습니다.");
                            }
                            break;
                        } else {
                            System.out.println("없는 몬스터 입니다.올바른 번호를 입력해주세요.");
                            monsterchoice = scanner.nextInt();
                        }
                    }
                } else if (battlechoice == 2) {
                    player.showSKill();
                    System.out.println("몇번 스킬을 사용하시겠습니까?");
                    while (true) {
                        int skillchoice = scanner.nextInt();


                        if (skillchoice > 0 && skillchoice <= player.skillset.size()) {


                            Skill selectedSkill = player.getskill(skillchoice);

                            if (selectedSkill.damage > 0) {
                                System.out.println("누구를 공격하시겠습니까?");
                                System.out.println("1. "+ monster1.name);
                                System.out.println("2. "+ monster2.name);
                                System.out.println("선택 : ");
                                int monsterchoice = scanner.nextInt();

                                Monster targetMonster = null;
                                if(monsterchoice == 1) {
                                    targetMonster = monster1;
                                } else if (monsterchoice == 2) {
                                    targetMonster = monster2;
                                }
                                player.useSkill(selectedSkill, targetMonster);

                            } else {

                                player.useSkill(selectedSkill, null);
                            }

                            break;

                        } else {

                            System.out.println("스킬 목록에 없는 번호입니다. 다시 선택해주세요.");
                        }
                    }
                } else {
                    ArrayList<Item> usableItems = new ArrayList<>();
                    for (Item item : player.inventory) {
                        if (item.type.equals("회복") || item.type.equals("강화")) {
                            usableItems.add(item);
                        }
                    }

                    System.out.println("------ 아이템 ------");
                    for (int i = 1; i <= usableItems.size(); i++) {
                        Item item = usableItems.get(i - 1);

                        System.out.println(i + ". " + item.name + ": " + item.description);

                    }
                    System.out.println("--------------------");

                    if (usableItems.isEmpty()) {
                        System.out.println();
                        System.out.println("목록이 비어있어 사용할 아이템이 없습니다. 전투 선택지로 돌아갑니다.");
                        continue;
                    }


                    System.out.println("어떤 아이템을 사용하시겠습니까?");
                    boolean use = true;
                    System.out.println("선택 : ");
                    while (use) {


                        int battlechoice3 = scanner.nextInt();

                        if (battlechoice3 > usableItems.size()) {
                            System.out.println("--------------------");
                            System.out.println("다시 입력해 주십시오.");
                            System.out.println("--------------------");
                        } else {
                            Item select = usableItems.get(battlechoice3 - 1);

                            if (select.type.equals("강화")) {
                                player.useStrongPotion();
                                System.out.println("플레이어의 현재 공격력이 " + player.fightattack + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            } else {
                                player.useHpPotion();
                                System.out.println("플레이어의 현재 체력이 " + player.hp + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }

                        }
                    }


                }
                monster1.attackPlayer(player);


                if (player.hp > 0) {
                    monster2.attackPlayer(player);
                }

                // 턴이 끝난 후 플레이어가 죽었는지 최종 확인
                if (player.hp <= 0) {
                    break; // 전투 종료
                }

                if (monster1.hp == 0 && monster2.hp == 0) {
                    System.out.println("적을 모두 처치했습니다.");
                    int rewardexp = monster1.rewardExp + monster2.rewardExp;
                    player.addItemToInventory(itemlist.getLeatherHelmet());
                    player.getGold(100);
                    player.getExperience(rewardexp);
                    player.levelUp();
                    player.addSkill(skilllist.whirlwind());

                    break;
                }


            }

        }
    }

    void battleFloor6() {
        Stage battlestage = stagelist.floor6();
        System.out.println(battlestage.name + "에 입장 하셨습니다.");
        System.out.println();
        System.out.println("입장 레벨 : " + battlestage.entryLevel);
        System.out.println();
        System.out.println("======================================");
        if (player.level < battlestage.entryLevel) {

            System.out.println("적정 레벨이 아닙니다. 야영지로 돌아갑니다.");


        } else {
            System.out.println();
            Monster monster1 = monsterlist.highoakleader();


            System.out.println(monster1.name + "이 생성되었습니다.");


            Random random = new Random();

            while (player.hp > 0) {
                System.out.println("플레이어의 체력 : " + player.hp);
                System.out.println(monster1. name + "의 체력 : " + monster1.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");
                System.out.println("선택 : ");

                int battlechoice = scanner.nextInt();


                if (battlechoice == 1) {

                    monster1.hp -= player.fightattack;
                    System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                    if (monster1.hp <= 0) {
                        monster1.hp = 0;
                        System.out.println(monster1.name + "이 쓰러졌습니다.");
                    }

                } else if (battlechoice == 2) {
                    player.showSKill();
                    System.out.println("몇번 스킬을 사용하시겠습니까?");
                    while (true) {
                        int skillchoice = scanner.nextInt();


                        if (skillchoice > 0 && skillchoice <= player.skillset.size()) {


                            Skill selectedSkill = player.getskill(skillchoice);

                            if (selectedSkill.damage > 0) {



                                    Monster targetMonster = monster1;
                                player.useSkill(selectedSkill, targetMonster);

                            } else {

                                player.useSkill(selectedSkill, null);
                            }

                            break;

                        } else {

                            System.out.println("스킬 목록에 없는 번호입니다. 다시 선택해주세요.");
                        }
                    }
                } else {
                    ArrayList<Item> usableItems = new ArrayList<>();
                    for (Item item : player.inventory) {
                        if (item.type.equals("회복") || item.type.equals("강화")) {
                            usableItems.add(item);
                        }
                    }

                    System.out.println("------ 아이템 ------");
                    for (int i = 1; i <= usableItems.size(); i++) {
                        Item item = usableItems.get(i - 1);

                        System.out.println(i + ". " + item.name + ": " + item.description);

                    }
                    System.out.println("--------------------");

                    if (usableItems.isEmpty()) {
                        System.out.println();
                        System.out.println("목록이 비어있어 사용할 아이템이 없습니다. 전투 선택지로 돌아갑니다.");
                        continue;
                    }


                    System.out.println("어떤 아이템을 사용하시겠습니까?");
                    boolean use = true;
                    System.out.println("선택 : ");
                    while (use) {


                        int battlechoice3 = scanner.nextInt();

                        if (battlechoice3 > usableItems.size()) {
                            System.out.println("--------------------");
                            System.out.println("다시 입력해 주십시오.");
                            System.out.println("--------------------");
                        } else {
                            Item select = usableItems.get(battlechoice3 - 1);

                            if (select.type.equals("강화")) {
                                player.useStrongPotion();
                                System.out.println("플레이어의 현재 공격력이 " + player.fightattack + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            } else {
                                player.useHpPotion();
                                System.out.println("플레이어의 현재 체력이 " + player.hp + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }

                        }
                    }


                }
                monster1.attackPlayer(player);

                if (player.hp <= 0) {
                    break;
                }


                if (monster1.hp == 0) {
                    System.out.println("적을 모두 처치했습니다.");
                    int rewardexp = monster1.rewardExp;
                    player.getGold(100);
                    player.getExperience(rewardexp);
                    player.levelUp();
                    player.addItemToDevilstone(itemlist.getdevilRedStone());
                    break;
                }


            }

        }
    }

    void battleFloor7() {
        Stage battlestage = stagelist.floor7();
        System.out.println(battlestage.name + "에 입장 하셨습니다.");
        System.out.println();
        System.out.println("입장 레벨 : " + battlestage.entryLevel);
        System.out.println();
        System.out.println("======================================");
        if (player.level < battlestage.entryLevel) {

            System.out.println("적정 레벨이 아닙니다. 야영지로 돌아갑니다.");


        } else {
            System.out.println();
            Monster monster1 = monsterlist.undeadwarrior();
            Monster monster2 = monsterlist.undeadmagician();

            System.out.println(monster1.name + "가 생성되었습니다.");
            System.out.println(monster2.name + "가 생성되었습니다.");


            Random random = new Random();

            while (player.hp > 0) {
                System.out.println("플레이어의 체력 : " + player.hp);
                System.out.println(monster1.name + "의 체력 : " + monster1.hp);
                System.out.println(monster2.name  + "의 체력 : " + monster2.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");
                System.out.println("선택 : ");

                int battlechoice = scanner.nextInt();


                if (battlechoice == 1) {
                    System.out.println("누구를 공격하시겠습니까?");
                    System.out.println("1. " + monster1.name );
                    System.out.println("2. " + monster2.name );
                    System.out.println("선택 : ");
                    int monsterchoice = scanner.nextInt();
                    while (true) {
                        if (monsterchoice == 1) {
                            monster1.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                            if (monster1.hp <= 0) {
                                monster1.hp = 0;
                                System.out.println(monster1.name  + "가 쓰러졌습니다.");
                            }


                            break;
                        } else if (monsterchoice == 2) {
                            monster2.hp -= player.fightattack;
                            System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                            if (monster2.hp <= 0) {
                                monster2.hp = 0;
                                System.out.println(monster2.name + "가 쓰러졌습니다.");
                            }
                            break;
                        } else {
                            System.out.println("없는 몬스터 입니다.올바른 번호를 입력해주세요.");
                            monsterchoice = scanner.nextInt();
                        }
                    }
                } else if (battlechoice == 2) {
                    player.showSKill();
                    System.out.println("몇번 스킬을 사용하시겠습니까?");
                    while (true) {
                        int skillchoice = scanner.nextInt();


                        if (skillchoice > 0 && skillchoice <= player.skillset.size()) {


                            Skill selectedSkill = player.getskill(skillchoice);

                            if (selectedSkill.damage > 0) {
                                System.out.println("누구를 공격하시겠습니까?");
                                System.out.println("1. "+ monster1.name);
                                System.out.println("2. "+ monster2.name);
                                System.out.println("선택 : ");
                                int monsterchoice = scanner.nextInt();

                                Monster targetMonster = null;
                                if(monsterchoice == 1) {
                                    targetMonster = monster1;
                                } else if (monsterchoice == 2) {
                                    targetMonster = monster2;
                                }
                                player.useSkill(selectedSkill, targetMonster);

                            } else {

                                player.useSkill(selectedSkill, null);
                            }

                            break;

                        } else {

                            System.out.println("스킬 목록에 없는 번호입니다. 다시 선택해주세요.");
                        }
                    }

                } else {
                    ArrayList<Item> usableItems = new ArrayList<>();
                    for (Item item : player.inventory) {
                        if (item.type.equals("회복") || item.type.equals("강화")) {
                            usableItems.add(item);
                        }
                    }

                    System.out.println("------ 아이템 ------");
                    for (int i = 1; i <= usableItems.size(); i++) {
                        Item item = usableItems.get(i - 1);

                        System.out.println(i + ". " + item.name + ": " + item.description);

                    }
                    System.out.println("--------------------");

                    if (usableItems.isEmpty()) {
                        System.out.println();
                        System.out.println("목록이 비어있어 사용할 아이템이 없습니다. 전투 선택지로 돌아갑니다.");
                        continue;
                    }


                    System.out.println("어떤 아이템을 사용하시겠습니까?");
                    boolean use = true;
                    System.out.println("선택 : ");
                    while (use) {


                        int battlechoice3 = scanner.nextInt();

                        if (battlechoice3 > usableItems.size()) {
                            System.out.println("--------------------");
                            System.out.println("다시 입력해 주십시오.");
                            System.out.println("--------------------");
                        } else {
                            Item select = usableItems.get(battlechoice3 - 1);

                            if (select.type.equals("강화")) {
                                player.useStrongPotion();
                                System.out.println("플레이어의 현재 공격력이 " + player.fightattack + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            } else {
                                player.useHpPotion();
                                System.out.println("플레이어의 현재 체력이 " + player.hp + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }

                        }
                    }


                }
                monster1.attackPlayer(player);

                if (player.hp > 0) {
                    monster2.attackPlayer(player);
                }

                if (player.hp <= 0) {
                    break;
                }

                if (monster1.hp == 0 && monster2.hp == 0) {
                    System.out.println("적을 모두 처치했습니다.");
                    int rewardexp = monster1.rewardExp + monster2.rewardExp;
                    player.addItemToInventory(itemlist.getSteelHelmet());
                    player.addItemToInventory(itemlist.getSteelArmor());
                    player.getGold(100);
                    player.getExperience(rewardexp);
                    player.levelUp();
                    player.addSkill(skilllist.crush());

                    break;
                }


            }

        }
    }

    void battleFloor8() {
        Stage battlestage = stagelist.floor8();
        System.out.println(battlestage.name + "에 입장 하셨습니다.");
        System.out.println();
        System.out.println("입장 레벨 : " + battlestage.entryLevel);
        System.out.println();
        System.out.println("======================================");
        if (player.level < battlestage.entryLevel) {

            System.out.println("적정 레벨이 아닙니다. 야영지로 돌아갑니다.");


        } else {
            System.out.println();
            Monster monster1 = monsterlist.undeadleader();
            ;

            System.out.println(monster1.name + "이 생성되었습니다.");


            Random random = new Random();

            while (player.hp > 0) {
                System.out.println("플레이어의 체력 : " + player.hp);
                System.out.println(monster1.name  + "의 체력 : " + monster1.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");
                System.out.println("선택 : ");

                int battlechoice = scanner.nextInt();


                if (battlechoice == 1) {

                    monster1.hp -= player.fightattack;
                    System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                    if (monster1.hp <= 0) {
                        monster1.hp = 0;
                        System.out.println(monster1.name + "가 쓰러졌습니다.");
                    }

                } else if (battlechoice == 2) {
                    player.showSKill();
                    System.out.println("몇번 스킬을 사용하시겠습니까?");
                    while (true) {
                        int skillchoice = scanner.nextInt();


                        if (skillchoice > 0 && skillchoice <= player.skillset.size()) {


                            Skill selectedSkill = player.getskill(skillchoice);

                            if (selectedSkill.damage > 0) {



                                Monster targetMonster = monster1;
                                player.useSkill(selectedSkill, targetMonster);

                            } else {

                                player.useSkill(selectedSkill, null);
                            }

                            break;

                        } else {

                            System.out.println("스킬 목록에 없는 번호입니다. 다시 선택해주세요.");
                        }
                    }
                } else {
                    ArrayList<Item> usableItems = new ArrayList<>();
                    for (Item item : player.inventory) {
                        if (item.type.equals("회복") || item.type.equals("강화")) {
                            usableItems.add(item);
                        }
                    }

                    System.out.println("------ 아이템 ------");
                    for (int i = 1; i <= usableItems.size(); i++) {
                        Item item = usableItems.get(i - 1);

                        System.out.println(i + ". " + item.name + ": " + item.description);

                    }
                    System.out.println("--------------------");

                    if (usableItems.isEmpty()) {
                        System.out.println();
                        System.out.println("목록이 비어있어 사용할 아이템이 없습니다. 전투 선택지로 돌아갑니다.");
                        continue;
                    }


                    System.out.println("어떤 아이템을 사용하시겠습니까?");
                    boolean use = true;
                    System.out.println("선택 : ");
                    while (use) {


                        int battlechoice3 = scanner.nextInt();

                        if (battlechoice3 > usableItems.size()) {
                            System.out.println("--------------------");
                            System.out.println("다시 입력해 주십시오.");
                            System.out.println("--------------------");
                        } else {
                            Item select = usableItems.get(battlechoice3 - 1);

                            if (select.type.equals("강화")) {
                                player.useStrongPotion();
                                System.out.println("플레이어의 현재 공격력이 " + player.fightattack + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            } else {
                                player.useHpPotion();
                                System.out.println("플레이어의 현재 체력이 " + player.hp + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }

                        }
                    }


                }
                monster1.attackPlayer(player);

                if (player.hp <= 0) {
                    break;
                }


                if (monster1.hp == 0) {
                    System.out.println("적을 모두 처치했습니다.");
                    int rewardexp = monster1.rewardExp;
                    player.getGold(100);
                    player.getExperience(rewardexp);
                    player.levelUp();
                    player.addItemToDevilstone(itemlist.getdevilBlackStone());
                    break;
                }


            }

        }
    }

    boolean battleFloor9() {
        Stage battlestage = stagelist.floor9();
        System.out.println(battlestage.name + "에 입장 하셨습니다.");
        System.out.println();
        System.out.println("입장 레벨 : " + battlestage.entryLevel);
        System.out.println();
        System.out.println("======================================");
        if (player.level < battlestage.entryLevel) {

            System.out.println("적정 레벨이 아닙니다. 야영지로 돌아갑니다.");
            return false;

        } else {
            System.out.println();
            Monster monster1 = monsterlist.undeadking();


            System.out.println(monster1.name + "이 생성되었습니다.");


            Random random = new Random();

            while (player.hp > 0) {
                System.out.println("플레이어의 체력 : " + player.hp);
                System.out.println(monster1.name + "의 체력 : " + monster1.hp);
                System.out.println("-- 플레이어턴 -- ");
                System.out.println("1. 일반 공격");
                System.out.println("2. 스킬 사용");
                System.out.println("3. 아이템 사용");
                System.out.println("선택 : ");

                int battlechoice = scanner.nextInt();


                if (battlechoice == 1) {

                    monster1.hp -= player.fightattack;
                    System.out.println("일반 공격으로" + player.fightattack + " 데미지를 주었습니다.");

                    if (monster1.hp <= 0) {
                        monster1.hp = 0;
                        System.out.println(monster1.name + "이 쓰러졌습니다.");
                    }

                } else if (battlechoice == 2) {
                    player.showSKill();
                    System.out.println("몇번 스킬을 사용하시겠습니까?");
                    while (true) {
                        int skillchoice = scanner.nextInt();


                        if (skillchoice > 0 && skillchoice <= player.skillset.size()) {


                            Skill selectedSkill = player.getskill(skillchoice);

                            if (selectedSkill.damage > 0) {



                                Monster targetMonster = monster1;
                                player.useSkill(selectedSkill, targetMonster);

                            } else {

                                player.useSkill(selectedSkill, null);
                            }

                            break;

                        } else {

                            System.out.println("스킬 목록에 없는 번호입니다. 다시 선택해주세요.");
                        }
                    }

                } else {
                    ArrayList<Item> usableItems = new ArrayList<>();
                    for (Item item : player.inventory) {
                        if (item.type.equals("회복") || item.type.equals("강화")) {
                            usableItems.add(item);
                        }
                    }

                    System.out.println("------ 아이템 ------");
                    for (int i = 1; i <= usableItems.size(); i++) {
                        Item item = usableItems.get(i - 1);

                        System.out.println(i + ". " + item.name + ": " + item.description);

                    }
                    System.out.println("--------------------");

                    if (usableItems.isEmpty()) {
                        System.out.println();
                        System.out.println("목록이 비어있어 사용할 아이템이 없습니다. 전투 선택지로 돌아갑니다.");
                        continue;
                    }


                    System.out.println("어떤 아이템을 사용하시겠습니까?");
                    boolean use = true;
                    System.out.println("선택 : ");
                    while (use) {


                        int battlechoice3 = scanner.nextInt();

                        if (battlechoice3 > usableItems.size()) {
                            System.out.println("--------------------");
                            System.out.println("다시 입력해 주십시오.");
                            System.out.println("--------------------");
                        } else {
                            Item select = usableItems.get(battlechoice3 - 1);

                            if (select.type.equals("강화")) {
                                player.useStrongPotion();
                                System.out.println("플레이어의 현재 공격력이 " + player.fightattack + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            } else {
                                player.useHpPotion();
                                System.out.println("플레이어의 현재 체력이 " + player.hp + "가 되었습니다.");
                                System.out.println("--------------------");
                                usableItems.remove(select);
                                player.inventory.remove(select);
                                use = false;
                            }

                        }
                    }


                }
                monster1.attackPlayer(player);

                if (player.hp <= 0) {
                    return false;
                }


                if (monster1.hp == 0) {
                    System.out.println("....................");
                    System.out.println("...!");
                    System.out.println("언데드 왕이 기분 나쁜 비명과 함께 육중한 소리를 내며 무너집니다.");
                    System.out.println("왕을 지탱하던 불길한 어둠의 마력이 폭풍처럼 휘몰아치다... 이내 잠잠해집니다.");
                    System.out.println();
                    System.out.println("9층 대표이사 집무실의 거대한 창 밖으로,");
                    System.out.println("어둠에 가려져 있던 도시의 햇살이 눈부시게 비추기 시작합니다.");
                    System.out.println();
                    System.out.println("4층부터 9층까지, 이 건물을 뒤덮었던 모든 마물들이 먼지가 되어 소멸합니다.");
                    System.out.println();
                    System.out.println(player.name + "님, 당신은 마침내 이 빌딩의 평화를 되찾았습니다.");
                    System.out.println("축하합니다. 모든 시련을 이겨냈습니다.");
                    System.out.println();
                    System.out.println("==================");
                    System.out.println("   GAME CLEAR   ");
                    System.out.println("==================");
                    System.out.println();

                     return true;
                }


            }
            return false;
        }
    }
}

