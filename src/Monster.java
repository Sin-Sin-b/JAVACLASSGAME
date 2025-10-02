public class Monster {
    String name;
    String type;
    int attack;
    int hp;
    int level;
    int rewardExp;


    Monster(String name,String type, int attack, int hp, int level,int rewardExp) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
        this.level = level;
        this.rewardExp = rewardExp;
    }
    static Monster create(String monsterName){
    switch(monsterName){
        case "고블린 전사":
        return new Monster("고블린 전사","일반",10,30,1,50);

        case "고블린 궁수":
        return new Monster("고블린 궁수","일반",15,20,1,50);

        case "하이오크 전사":
        return new Monster("하이오크 전사","일반",15,60,2,75);

        case "하이오크 궁수":
        return new Monster("하이오크 궁수","일반",20,40,2,75);

        case "하이오크 장군":
        return new Monster("하이오크 장군","중간보스",40,150,3,200);

        case"언데드 검사":
        return new Monster("언데드 검사","일반",25,120,4,125);

        case"언데드 마법사":
        return new Monster("언데드 마법사","일반",30,80,4,125);

        case"언데드 기사":
        return new Monster("언데드 기사","일반",35,200,5,150);

        case"언데드 왕":
        return new Monster("언데드 왕","보스",70,360,5,150);

        default:
            System.out.println("알 수 없는 몬스터 이름입니다: " + monsterName + ". 기본 고블린 전사를 생성합니다.");
            return new Monster("고블린 전사","일반",10,30,1,50);
    }
    }


}
