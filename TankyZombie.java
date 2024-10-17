package Zombie_Project;

public class TankyZombie extends Zombie{
    public TankyZombie(){
        super();
        zsetAttack(-8);
        zsetHeal(50);
        zsetSpeed(-5);
        zsetName("Tanky Zombie");
    }
}
