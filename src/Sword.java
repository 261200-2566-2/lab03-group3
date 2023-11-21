public class Sword {
    private double d=10;
    private double damage;
    private int swordLevel;

    Sword(int swordLevel){
        this.swordLevel = swordLevel;
        damage = d*(1+0.1*swordLevel);

    }

    void swordLevelUp(){
        swordLevel++;
        damage = d*(1+0.1*swordLevel);
    }

    double reducedSpeedBySword(){
        return 0.1+0.04*swordLevel;
    }

    double getDamage(){
        return damage;

    }

}
