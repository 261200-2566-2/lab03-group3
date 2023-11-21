
public class Main {
    public static void main(String[] args) {
        Character c =  new Character(5);c.printStat();
        c.levelUp();
        c.EquipSword(new Sword(1));c.printStat();
        c.EquipShield(new Shield(2));c.printStat();


    }
}