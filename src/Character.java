public class Character {

    private double maxHp;
    private double currentHp;
    private int level;

    private double maxMana;

    private double r=10;

    private double maxRunSpeed;
    private double currentRunSpeed;

    Sword currentSword=null;
    Shield currentShield=null;

    private double currentAtk=1;
    private double currentDef=5;

    Character(int level){
        this.level = level;
        maxHp = 100+10*level;
        maxMana = 50+2*level;
        maxRunSpeed = r*(0.1+0.03*level);

        currentHp = maxHp;
        currentRunSpeed = maxRunSpeed;
    }

    void printStat(){
        System.out.println("MaxHp: "+maxHp+" | CurrentHp: "+currentHp+" | MaxMana: "+maxMana+" | MaxRunSpeed: "+maxRunSpeed+" | CurrentRunSpeed: "+currentRunSpeed+" | CurrentAtk: "+currentAtk+" | CurrentDef: "+currentDef);
    }

    void levelUp(){
        level++;
        maxHp = 100+10*level;
        maxMana = 50+2*level;
        maxRunSpeed = r*(0.1+0.03*level);

    }

    void EquipSword(Sword sword){

        currentSword = sword;
        if(currentSword == null){
            currentAtk=1;
            return;
        }
        currentRunSpeed -= r * sword.reducedSpeedBySword();
        if(currentRunSpeed<0) currentRunSpeed=0;
        currentAtk = currentSword.getDamage();
    }

    void EquipShield(Shield shield){
        currentShield = shield;
        if(currentShield == null){
            currentDef=5;
            return;
        }
        currentRunSpeed -= r * shield.reducedSpeedByShield();
        if(currentRunSpeed<0) currentRunSpeed=0;
        currentDef = currentShield.getDefense();
    }

    void getAttacked(double atk){ // atk Received From currentAtk of Opponent
        currentHp -= atk-0.5*currentDef;
    }

}
