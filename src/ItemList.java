public class ItemList {

Item getStrPotion(){return new Item("힘의 포션","본인의 공격력을 10% 올려주는 포션이다",10,"강화",1.1,0,0);}

Item getHealPotion(){return new Item("회복 포션","본인의 체력을 최대체력의 20% 회복한다",10, "회복",0,0,0.2);}

Item getLeatherArmor(){return new Item("가죽 갑옷","짜임새 좋은 가죽갑옷이다. 체력을 +30 늘려준다.",20,"방어구",0,30,0);}

Item getLeatherHelmet(){return new Item("가죽 헬멧","짜임새 좋은 가죽헬멧이다. 체력을 +30 늘려준다.",20,"방어구",0,30,0);}

Item getSteelArmor(){return new Item("강철 갑옷","튼튼한 강철 갑옷이다. 체력을 +50 늘려준다.",30,"방어구",0,50,0);}

Item getSteelHelmet(){return new Item("강철 헬멧","튼튼한 강철 헬멧이다. 체력을 +50 늘려준다.",30,"방어구",0,50,0);}

Item devilStone(){return new Item("붉은 마석","불길한 마석이다.",0,"강화석",0,0,0);}


}
