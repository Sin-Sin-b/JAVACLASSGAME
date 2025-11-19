public class BuffSKillHpCost extends BuffSkill{
    double hpCostRatio;
    BuffSKillHpCost(String name, String description, String job,String category, int requiredLevel, double attackMultiplier, double hpCostRatio) {
        super(name, description, job, category,requiredLevel, attackMultiplier);
        this.hpCostRatio = hpCostRatio;
    }

}
