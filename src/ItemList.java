public class ItemList {

    Item getStrPotion() {
        return new Consumable("힘의 포션", "본인의 공격력을 30% 올려주는 포션이다", 10, "강화", 1.3, 0);
    }

    Item getHealPotion() {
        return new Consumable("회복 포션", "본인의 체력을 최대체력의 50% 회복한다", 10, "회복", 0, 0.2);
    }

    Item getLeatherArmor() {
        return new Equipment("가죽 갑옷", "짜임새 좋은 가죽갑옷이다. 체력을 +30 늘려준다.", 20, 30);
    }

    Item getLeatherHelmet() {
        return new Equipment("가죽 헬멧", "짜임새 좋은 가죽헬멧이다. 체력을 +30 늘려준다.", 20,30);
    }

    Item getSteelArmor() {
        return new Equipment("강철 갑옷", "튼튼한 강철 갑옷이다. 체력을 +50 늘려준다.", 30, 50);
    }

    Item getSteelHelmet() {
        return new Equipment("강철 헬멧", "튼튼한 강철 헬멧이다. 체력을 +50 늘려준다.", 30,50);
    }

    Item getdevilRedStone() {

        return new Material("붉은 마석", "불길한 마석이다.큰 힘이 느껴진다.", 0, "1차강화석");
    }

    Item getdevilBlackStone() {
        return new Material("검은 마석", "불길한 마석이다.거대한 힘이 느껴진다.", 0, "2차강화석");
    }




}
