public class SkillList {

Skill cut(){return new Skill("횡베기","대상을 벤다","일반스킬",20,1);}

Skill berserk(){return new Skill("광폭화","체력을 일정량 사용하여 공격력을 증가시킨다.","일반스킬",0,2);}

Skill whirlwind() { return new Skill("휠윈드","회전하여 적을 공격한다(50% 확률로 두명의 적에게 적중한다","일반스킬", 30,4);}

Skill crush() {return new Skill("분쇄","적에게 강한 일격을 날린다.","일반스킬",45,5);}

Skill ruinousWave() {return new Skill("파멸의 검기", "전방으로 파괴적인 어둠 검기를 날린다", "마검스킬", 60, 3);}

Skill demonic() {return new Skill("마신화", "마검에 몸을 맡겨 마신화를 합니다. 공격력이 폭발적으로 증가합니다", "마검스킬", 0, 6);}


}
