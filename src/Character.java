public class Character {

    private double maxHp; // Maximum HP (Constant)
    private double currentHp;
    private int level;

    private double maxMana; // Constant

    private double r=10; // Constant

    private double maxRunSpeed; // Constant
    private double currentRunSpeed;


    Sword currentSword=null; // Sword Equipped? / Can Hold only 1
    Shield currentShield=null; // Shield Equipped? / Can Hold only 1

    private double currentAtk=1; // Default Attack of Character
    private double currentDef=5; // Default Defense of Character

    Character(int level){ // Constructor
        this.level = level;
        maxHp = 100+10*level;
        maxMana = 50+2*level;
        maxRunSpeed = r*(0.1+0.03*level);

        currentHp = maxHp; // Set HP
        currentRunSpeed = maxRunSpeed; // Set Speed
    }

    void printStat(){
        System.out.println("MaxHp: "+maxHp+" | CurrentHp: "+currentHp+" | MaxMana: "+maxMana+" | MaxRunSpeed: "+maxRunSpeed+" | CurrentRunSpeed: "+currentRunSpeed+" | CurrentAtk: "+currentAtk+" | CurrentDef: "+currentDef);
    }

    void levelUp(){ // Update level and Stats
        level++;
        maxHp = 100+10*level;
        maxMana = 50+2*level;
        maxRunSpeed = r*(0.1+0.03*level);

    }

    void EquipSword(Sword sword){ // Get atk stat from sword and get reducedSpeed that computed from sword level

        currentSword = sword;
        if(currentSword == null){ // Avoid null case
            currentAtk=1;
            return;
        }
        currentRunSpeed -= r * sword.reducedSpeedBySword(); // Character speed reduced from Holding sword;
        if(currentRunSpeed<0) currentRunSpeed=0;
        currentAtk = currentSword.getDamage();
    }

    void EquipShield(Shield shield){ // Get def stat from shield and get reducedSpeed that computed from shield level
        currentShield = shield;
        if(currentShield == null){ // Avoid null case
            currentDef=5;
            return;
        }
        currentRunSpeed -= r * shield.reducedSpeedByShield(); // Character speed reduced from Holding shield
        if(currentRunSpeed<0) currentRunSpeed=0;
        currentDef = currentShield.getDefense();
    }

    void getAttacked(double atk){ // atk Received From currentAtk of Opponent
        currentHp -= atk-0.5*currentDef;
    }
    // Call function when this character get attacked by another

    void attack(Character c){ // Call function when attack opponent c
        c.getAttacked(currentAtk);
    }

}
