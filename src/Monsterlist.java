public class Monsterlist {
    MonsterSkillList ms = new MonsterSkillList();


    Monster goblinwarrior() {

        Monster m = new NormalMonster("고블린 전사", "일반", 10, 30, 1, 50);

        m.addSkill(ms.shieldBash());
        m.addSkill(ms.smash());
        return m;
    }

    Monster goblinarcher() {
        Monster m = new NormalMonster("고블린 궁수", "일반", 15, 20, 1, 50);
        m.addSkill(ms.rapidFire());
        m.addSkill(ms.headShot());
        return m;
    }


    Monster highoakwarrior() {
        Monster m = new NormalMonster("하이오크 전사", "일반", 15, 55, 2, 75);
        m.addSkill(ms.downStrike());
        m.addSkill(ms.whirlwind());
        return m;
    }

    Monster highoakarcher() {
        Monster m = new NormalMonster("하이오크 궁수", "일반", 20, 35, 2, 75);
        m.addSkill(ms.arrowRain());
        m.addSkill(ms.pointShot());
        return m;
    }


    Monster highoakleader() {

        Monster m = new BossMonster("하이오크 장군", "중간보스", 40, 145, 3, 200);
        m.addSkill(ms.downStrike());
        m.addSkill(ms.earthShatter());
        return m;
    }


    Monster undeadwarrior() {
        Monster m = new NormalMonster("언데드 검사", "일반", 25, 115, 4, 125);
        m.addSkill(ms.lightningSword());
        m.addSkill(ms.swordAura());
        return m;
    }

    Monster undeadmagician() {
        Monster m = new NormalMonster("언데드 마법사", "일반", 30, 75, 4, 125);
        m.addSkill(ms.thunder());
        m.addSkill(ms.energyBolt());
        return m;
    }


    Monster undeadleader() {
        Monster m = new BossMonster("언데드 기사", "중간보스", 55, 245, 5, 300);
        m.addSkill(ms.deathBreath());
        m.addSkill(ms.dimensionCut());
        return m;
    }

    Monster undeadking() {
        Monster m = new BossMonster("언데드 왕", "보스", 70, 355, 6, 150);
        m.addSkill(ms.eternalRest());
        m.addSkill(ms.doomStrike());
        return m;
    }
}

