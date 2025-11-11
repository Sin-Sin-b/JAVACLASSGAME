public class Character {

    String name;
    int level;
    double hp;

    void takeDamage(int damage) {
        this.hp -= damage;
    }
}