public class Shield {
    private int shieldLevel;
    private double s = 20;
    private double def;

    Shield(int shieldLevel){
        this.shieldLevel = shieldLevel;
        def = s*(1+0.05*shieldLevel);
    }

    void ShieldLevelUp(){
        shieldLevel++;
        def = s*(1+0.05*shieldLevel);
    }

    double reducedSpeedByShield(){
        return 0.1+0.08*shieldLevel;
    }

    double getDefense(){
        return def;
    }
}
