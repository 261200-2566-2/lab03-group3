public class Sword {
    private double d=10; // constant to later compute
    private double damage; // current damage
    private int swordLevel; // level that manipulate the speed reduced in character

    Sword(int swordLevel){ // Constructor
        this.swordLevel = swordLevel;
        damage = d*(1+0.1*swordLevel); // init current damage

    }

    void swordLevelUp(){ // Level up and update current damage
        swordLevel++;
        damage = d*(1+0.1*swordLevel);
    }

    double reducedSpeedBySword(){
        return 0.1+0.04*swordLevel;
    }
    // Pass this to another function in Character class to compute later

    double getDamage(){
        return damage;

    }

}
