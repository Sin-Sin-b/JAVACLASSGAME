public class Monsterlist {

    Monster goblinwarrior() {

        return new Monster("고블린 전사", "일반", 10, 30, 1, 50);
    }

    Monster goblinarcher() {

        return new Monster("고블린 궁수", "일반", 15, 20, 1, 50);
    }

    Monster highoakwarrior() {

        return new Monster("하이오크 전사", "일반", 15, 55, 2, 75);

    }


    Monster highoakarcher() {

        return new Monster("하이오크 궁수", "일반", 20, 35, 2, 75);

    }

    Monster highoakleader() {
        return new Monster("하이오크 장군", "중간보스", 40, 145, 3, 200);
    }

    Monster undeadwarrior() {
        return new Monster("언데드 검사", "일반", 25, 115, 4, 125);
    }

    Monster undeadmagician() {
        return new Monster("언데드 마법사", "일반", 30, 75, 4, 125);

    }

    Monster undeadleader() {

        return new Monster("언데드 기사","중간보스2",55,245,5,300);
    }

    Monster undeadking() {
        return new Monster("언데드 왕", "보스", 70, 355, 6, 150);
    }

}

