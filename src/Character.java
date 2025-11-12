public class Character {

    String name;
    int level;
    double hp;



    public Character(String name, int level, double hp) {
        this.name = name;
        this.level = level;
        this.hp = hp;
    }

    void takeDamage(int damage) {
        this.hp -= damage;
    }
}