public class BuffSKillHpCost extends BuffSkill{
    double hpCostRatio;
    BuffSKillHpCost(String name, String description, String job,String category, int requiredLevel, double attackMultiplier, double hpCostRatio) {
        super(name, description, job, category,requiredLevel, attackMultiplier);
        this.hpCostRatio = hpCostRatio;
    }

    @Override
    void execute(Player user, Monster target) {

        double hpCost = user.fullhp * this.hpCostRatio;
        user.hp -= hpCost;

        System.out.println("체력을 " + (int)hpCost + " 소모했습니다. (현재 체력: " + user.hp + ")");

        super.execute(user, target);
    }
}
