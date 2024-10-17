package Zombie_Project;
import java.util.*;
public class Player{
    private int attack;
    private int health;
    private int speed;
    private String name;
    private int[] coords = new int[2];
    private ArrayList<String> inv = new ArrayList<String>();
    public Player(String nam){
        attack = 20;
        health = 100;
        speed = 25;
        name = nam;
        coords[0] = 5;
        coords[1] = 0;
    }
    public void setAtt(int boost){
        attack+=boost;
    }
    public void setHeal(int heal){
        health+=heal;
    }
    public void setSpeed(int move_increase){
        speed+=move_increase;
    }
   public void setCoords(int[] nCoords){
    coords = nCoords;
   }

    
    public ArrayList<String> getInv(){
        return inv;
    }

    public void addInv(String item){
            inv.add(item.toLowerCase());
    }
    public boolean useItem(String itemUse){
        if (itemUse.toLowerCase().equals("master sword")){
            setAtt(15);
            inv.remove(itemUse);
            return true;
        }
        else if (itemUse.toLowerCase().equals("lizal boomerang")){
            setAtt(8);
            inv.remove(itemUse);
            return true;
        }
        else if (itemUse.toLowerCase().equals("hearty simmered fruit")){
            setHeal(40);
            inv.remove(itemUse);
            return true;
        }
        else if (itemUse.toLowerCase().equals("cooked meat")){
            setHeal(10);
            inv.remove(itemUse);
            return true;
        }
        else if (itemUse.toLowerCase().equals( "master sword")){
            setHeal(10);
            inv.remove(itemUse);
            return true;
        }
        else if (itemUse.toLowerCase().equals("zora boots")){
            setSpeed(10);
            inv.remove(itemUse);
            return true;
        }
        else{
            return false;
        }
    }
    public int getAtt(){
        return attack;
    }
    public int getHeal(){
        return health;
    }
    public int getSpeed(){
        return speed;
    }
    public String getName(){
        return name;
    }
    public int[] getCoords(){
        return coords;
    }
    public int[] getcopyCoords(){
        int[] copyCoords = new int[2];
        copyCoords[0] = coords[0];
        copyCoords[1] = coords[1];
        return copyCoords;
    }

    public int[] movePlayer(String howMove, int[] ocoords, String[][] map){
        if (howMove.equals("w")){
            if(ocoords[0] - 1 == -1){
                return ocoords;
            }
            else{
                ocoords[0]-=1;
                return ocoords;
            }
            
        }
        else if (howMove.equals("s")){
            if(ocoords[0] + 1 == map.length){
                return ocoords;
            }
            else{
                ocoords[0]+=1;
                return ocoords;
            }
        }
        else if (howMove.equals("a")){
            if(ocoords[1] - 1 == -1){
                return ocoords;
            }
            else{
                ocoords[1]-=1;
                return ocoords;
            }
        }
        else if (howMove.equals("d")){
            if(ocoords[1] + 1 == map[0].length){
                return ocoords;
            }
            else{
                ocoords[1]+=1;
                return ocoords;
            }
        }
        else{
            System.out.println("This is not a valid direction");
            return ocoords;
        }
                    
        }
    

    public boolean fight(Zombie zp){
        
        if(zp.zgetHeal() <= 0){
            System.out.println(zp.zgetHeal());
            return true;
        }
        else if(getHeal() <=0){
            return false;
        }
        else{
            if(getSpeed() >= zp.zgetSpeed()){
                zp.zsetHeal(-1*getAtt());
                System.out.println("Your health is " + getHeal() + " the enemies health is " + zp.zgetHeal());
                if (zp.zgetHeal() <=0){
                    return true;
                }
                setHeal(-1*zp.zgetAtt());
                System.out.println("Your health is " + getHeal() + " the enemies health is " + zp.zgetHeal());
                return fight(zp);
            }
            else{
                setHeal(-1*zp.zgetAtt());
                System.out.println("Your health is " + getHeal() + " the enemies health is " + zp.zgetHeal());
                if(getHeal()<=0){
                    return false;
                }
                zp.zsetHeal(-1*getAtt());
                System.out.println("Your health is " + getHeal() + " the enemies health is " + zp.zgetHeal());
                return fight(zp);
            }
        }
    }
    public boolean equals(int[] x, int[] y){
        if(x.length == y.length & x[0] == y[0] & x[1] == y[1]){
            return true;
        }
        else{
            return false;
        }
    }
}