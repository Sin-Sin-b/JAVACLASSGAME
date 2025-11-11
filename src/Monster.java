import java.util.Random;

public class Monster {
    String name;
    String type;
    int attack;
    double hp;
    int level;
    int rewardExp;
    Random random = new Random();

    Monster(String name, String type, int attack, int hp, int level, int rewardExp) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
        this.level = level;
        this.rewardExp = rewardExp;
    }

    void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
            System.out.println(this.name + "에게 " + damage + " 데미지를 주었습니다.");
            System.out.println(this.name + "이(가) 쓰러졌습니다.");
        } else {
            System.out.println(this.name + "에게 " + damage + " 데미지를 주었습니다.");
        }
    }

   void goblinAttackPlayer(Player targetPlayer) {

        if (this.hp > 0) {
            System.out.println("-- " + this.name + "의 턴 --");


            if (this.name.equals("고블린 전사")) {
                int pattern = random.nextInt(2);
                if (pattern == 0) {
                    System.out.println("고블린 전사가 방패치기를 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("고블린 전사가 강타를 사용했다.");
                    targetPlayer.takeDamage(this.attack + 10);
                }
            } else if (this.name.equals("고블린 궁수")) {
                int pattern = random.nextInt(2);
                if (pattern == 0) {
                    System.out.println("고블린 궁수가 속사를 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("고블린 궁수가 헤드샷을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 10);
                }
            } else {

                System.out.println(this.name + "이(가) 공격했다.");
                targetPlayer.takeDamage(this.attack);
            }
            System.out.println("--------------------");
        }
    }
    void highOakAttackPlayer(Player targetPlayer) {
        if (this.hp>0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);

            if (this.name.equals("하이오크 전사")) {
                if (pattern == 0) {
                    System.out.println("하이오크 전사가 내려치기를 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("하이오크 전사가 휠 윈드를 사용했다.");
                    targetPlayer.takeDamage(this.attack + 15); // Game.java의 버그 수정 (10 -> 15)
                }
            } else if (this.name.equals("하이오크 궁수")) {
                if (pattern == 0) {
                    System.out.println("하이오크 궁수가 화살비를 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("하이오크 궁수가 포인트 샷을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 15); // Game.java의 버그 수정 (10 -> 15)
                }
            }
            System.out.println("--------------------");
        }
    }

    void highOakLeaderAttackPlayer(Player targetPlayer) {
        if (this.hp>0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);

            if (this.name.equals("하이오크 장군")) {
                if (pattern == 0) {
                    System.out.println("하이오크 장군이 내려치기를 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("하이오크 장군이 대지의 일격을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 30); // Game.java의 버그 수정 (10 -> 30)
                }
            }
            System.out.println("--------------------");
        }
    }
    void undeadAttackPlayer(Player targetPlayer) {
        if (this.hp>0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);

            if (this.name.equals("언데드 검사")) {
                if (pattern == 0) {
                    System.out.println("언데드 검사가 벼락검을 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("언데드 검사가 검기를 사용했다.");
                    targetPlayer.takeDamage(this.attack + 20);
                }
            } else if (this.name.equals("언데드 마법사")) {
                if (pattern == 0) {
                    System.out.println("언데드 마법사가 전격을 사용했다.");
                    targetPlayer.takeDamage(this.attack);
                } else {
                    System.out.println("언데드 마법사가 에너지 볼트을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 20);
                }
            }
            System.out.println("--------------------");
        }
    }
    void undeadLeaderAttackPlayer(Player targetPlayer) {
        if (this.hp>0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);

            if (this.name.equals("언데드 기사")) {
                if (pattern == 0) {
                    System.out.println("언데드 기사가 죽음의 숨결을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 10);
                } else {
                    System.out.println("언데드 기사가 공간 베기를 사용했다.");
                    targetPlayer.takeDamage(this.attack + 30);
                }
            }
            System.out.println("--------------------");
        }
    }
    void undeadKingAttackPlayer(Player targetPlayer) {
        if (this.hp>0) {
            System.out.println("\n-- " + this.name + "의 턴 -- ");
            int pattern = random.nextInt(2);

            if (this.name.equals("언데드 왕")) {
                if (pattern == 0) {
                    System.out.println("언데드 왕이 영원한 안식처를 사용했다.");
                    targetPlayer.takeDamage(this.attack + 25);
                } else {
                    System.out.println("언데드 왕이 파멸의 일격을 사용했다.");
                    targetPlayer.takeDamage(this.attack + 50);
                }
            }
            System.out.println("--------------------");
        }
    }
}