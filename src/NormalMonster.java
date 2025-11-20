public class NormalMonster extends Monster {

    public NormalMonster(String name, String type, int attack, double hp, int level, int rewardExp) {
        super(name,type,attack, hp, level, rewardExp);
    }

        @Override
        public void attackPlayer(Player targetPlayer) {
            if (this.hp > 0) {
                System.out.println("\n-- " + this.name + "의 턴 --");
                int pattern = random.nextInt(2);


                if (this.name.equals("고블린 전사")) {
                    if (pattern == 0) {
                        System.out.println("고블린 전사가 방패치기를 사용했다.");
                        targetPlayer.takeDamage(this.attack);
                    } else {
                        System.out.println("고블린 전사가 강타를 사용했다.");
                        targetPlayer.takeDamage(this.attack + 10);
                    }

                } else if (this.name.equals("고블린 궁수")) {
                    if (pattern == 0) {
                        System.out.println("고블린 궁수가 속사를 사용했다.");
                        targetPlayer.takeDamage(this.attack);
                    } else {
                        System.out.println("고블린 궁수가 헤드샷을 사용했다.");
                        targetPlayer.takeDamage(this.attack + 10);
                    }

                } else if (this.name.equals("하이오크 전사")) {
                    if (pattern == 0) {
                        System.out.println("하이오크 전사가 내려치기를 사용했다.");
                        targetPlayer.takeDamage(this.attack);
                    } else {
                        System.out.println("하이오크 전사가 휠 윈드를 사용했다.");
                        targetPlayer.takeDamage(this.attack + 15);
                    }

                } else if (this.name.equals("하이오크 궁수")) {
                    if (pattern == 0) {
                        System.out.println("하이오크 궁수가 화살비를 사용했다.");
                        targetPlayer.takeDamage(this.attack);
                    } else {
                        System.out.println("하이오크 궁수가 포인트 샷을 사용했다.");
                        targetPlayer.takeDamage(this.attack + 15);
                    }

                } else if (this.name.equals("언데드 검사")) {
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

}
