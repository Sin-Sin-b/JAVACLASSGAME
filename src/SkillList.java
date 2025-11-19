public class SkillList {

    Skill cut() {
        return new DamageSkill("횡베기", "대상을 벤다", "Warrior", "일반", 1, 10);
    }

    Skill berserk() {
        return new BuffSKillHpCost("광폭화", "체력 10%를 사용하여 공격력을 30% 증가시킨다.", "Warrior", "일반", 2, 0.3,0.1);
    }

    Skill whirlwind() {
        return new DamageSkill("휠윈드", "회전하여 적을 공격한다", "Warrior", "일반", 3, 30);
    }

    Skill crush() {
        return new DamageSkill("분쇄", "적에게 강한 일격을 날린다.", "Warrior", "일반", 5, 45);
    }

    Skill ruinousWave() {
        return new DamageSkill("파멸의 검기", "전방으로 파괴적인 어둠 검기를 날린다", "Warrior", "마검", 4, 55);
    }

    Skill demonic() {
        return new BuffSkill("마신화", "마검에 몸을 맡겨 마신화를 합니다. 공격력이 폭발적으로 증가합니다", "Warrior", "마검", 6, 2);
    }



    Skill doubleshot(){
     return new DamageSkill("더블샷","화살 두 발을 빠르게 연속으로 발사한다.","Archer","일반",1,10);
    }

    Skill eagleeye() {
        return new BuffSkill("매의눈", "집중력을 높여 공격력을 20% 증가시킨다", "Archer", "일반", 2, 0.2);

    }

    Skill Powershot(){
        return new DamageSkill("파워샷","힘을 모아 강력한 화살을 발사한다.","Archer","일반",3,30);
    }

    Skill Snipe(){
        return new DamageSkill("스나이프","적의 약점을 정밀히 노려 치명적인 피해를 줍니다.","Archer","일반",5,50);
    }

    Skill blazingArrow() {
        return new DamageSkill("공허의 화살", "공허의 힘을 화살에 담아 강력한 화살을 쏩니다.", "Archer","마궁", 4, 55);
    }

    Skill abyssSight() {
        return new BuffSkill("심연의 눈", "마궁의 힘으로 심연의 눈을 개방한다. 공격력이 두배 증가한다.", "Archer","마궁",6,2);
    }

}
