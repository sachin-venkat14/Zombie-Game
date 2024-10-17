package Zombie_Project;

public class Zombie {
    private int zattack;
    private int zhealth;
    private int zspeed;
    private String zname;
    public Zombie(){
        zattack = 15;
        zhealth = 50;
        zspeed = 15;
        zname = "Zombie";

    }
   
    public void zsetName(String zname){
        this.zname = zname;
    }    
    public void zsetSpeed(int zspe){
        zspeed  += zspe;
    }
    public void zsetHeal(int zheal){
        zhealth += zheal;
    }
    public void zsetAttack(int zatck){
        zattack += zatck;
    }
    public int zgetAtt(){
        return zattack;
    }
    public int zgetHeal(){
        return zhealth;
    }
    public int zgetSpeed(){
        return zspeed;
    }
   
    public String zgetName(){
        return zname;
    }
}
