public class Shield {
    private int shieldLevel; // Shield level manipualte speed reduced of character
    private double s = 20; // Def constant
    private double def; // Current Defense

    Shield(int shieldLevel){ // Constructor
        this.shieldLevel = shieldLevel;
        def = s*(1+0.05*shieldLevel); // init current defense
    }

    void ShieldLevelUp(){ // Level up and update current defense
        shieldLevel++;
        def = s*(1+0.05*shieldLevel);
    }

    double reducedSpeedByShield(){
        return 0.1+0.08*shieldLevel;
    } // Pass the reduced speed from shield

    double getDefense(){
        return def;
    }
}
