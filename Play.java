package Zombie_Project;
import java.util.*;
public class Play {
    public static void main(String[] args){
   
        String[][] playMap = new String[6][6];
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the zombie dungeon. Your goal is to make it out of the dungeon without dying to the zombies that are inside of it. When you look at the map you will see that you start at position (5, 0). Your Goal is to make it all the way to position (0,5) or the exit. Everytime you move there is a chacne to encounter a zombie of differing types, find an item that will give you powerful bonuses or find nothing at all. Reaching the exit is your ultimate goal so have a great time exploring the vast dungeon!");
        System.out.println("Before you begin playing being by entering your name: ");
        String name = console.nextLine();
        Player p1 = new Player(name);
        Random rand = new Random();
        boolean winGame = true;
        Supply supInfo = new Supply();
        mapDisplay(playMap, p1.getCoords());
        System.out.println("Now get ready to begin your journey exploring these dungeons and have fun " + p1.getName() + "!");
        
        while(p1.getHeal()>=0 & (p1.getCoords()[0] != 0 || p1.getCoords()[1] != 5)){
            System.out.println("Where would you like to move next? Choose w to move up, s to move down, a to move left, and d to move right.");
            String movePlace = console.next();
            int[] playerNewPos = p1.movePlayer(movePlace, p1.getcopyCoords(), playMap);
            while(p1.equals(p1.getCoords(), playerNewPos)){
                System.out.println("Please enter a valid direction! Choose w to move up, s to move down, a to move left, and d to move right:");
                movePlace = console.next();
                playerNewPos = p1.movePlayer(movePlace, p1.getcopyCoords(), playMap);
            }
            p1.setCoords(p1.movePlayer(movePlace, p1.getcopyCoords(), playMap));
            mapDisplay(playMap, playerNewPos);
            int encounter = rand.nextInt(10) + 1;
            if(encounter == 1 || encounter == 2|| encounter == 3){
                Zombie zomb = new Zombie();
                System.out.println("You encountered a " + zomb.zgetName());
                System.out.print("You're inventory currently contains: ");
                for(int i = 0; i<p1.getInv().size(); i++){
                    System.out.print(p1.getInv().get(i) + ", ");
                }
                System.out.println();
                System.out.println("Would you like to use an item before you fight? If so please enter your item here otherwise enter no. (If you don't enter no and enter something else we assume you want to use an item!): ");
                console.nextLine();
                String item = console.nextLine();
                if((!(item.equals("no")) & p1.getInv().size() != 0)){
                    boolean success = p1.useItem(item);
                    while(success != true){
                        System.out.println("Please choose an item from your inventory:");
                        item = console.nextLine();
                        success = p1.useItem(item);
                    }
                    System.out.println("Here is your updated inventory: ");
                    for(int i = 0; i<p1.getInv().size(); i++){
                        System.out.print(p1.getInv().get(i) + ", ");
                    }
                    System.out.println();
                }
                
                System.out.println("Now you will fight the zombie!");
                boolean winOrNot = p1.fight(zomb);
                if (winOrNot == true){
                    System.out.println("Congrats on winning your fight! Your current health is " + p1.getHeal() + ". Your current speed is " + p1.getSpeed() + ". Your current attack is " + p1.getAtt());
                }
                else{
                    winGame = false;
                    break;
                }
            }
            else if(encounter == 4){
                TankyZombie tankZomb = new TankyZombie();
                System.out.println("You encountered a " + tankZomb.zgetName());
                System.out.print("You're inventory currently contains: ");
                for(int i = 0; i<p1.getInv().size(); i++){
                    System.out.print(p1.getInv().get(i) + ", ");
                }
                System.out.println();
                System.out.println("Would you like to use an item before you fight? If so please enter your item here otherwise enter no. (If you don't enter no and enter something else we assume you want to use an item!): ");
                console.nextLine();
                String item = console.nextLine();
                if((!(item.equals("no")) & p1.getInv().size() != 0)){
                    boolean success = p1.useItem(item);
                    System.out.println(p1.getInv());
                while(success != true){
                    System.out.println("Please choose an item from your inventory:");
                    item = console.nextLine();
                    success = p1.useItem(item);
                }
                System.out.println("Here is your updated inventory: ");
                for(int i = 0; i<p1.getInv().size(); i++){
                    System.out.print(p1.getInv().get(i) + ", ");
                }
                System.out.println();
                }
                System.out.println("Now you will fight the zombie!");
                boolean winOrNot = p1.fight(tankZomb);
                if (winOrNot == true){
                    System.out.println("Congrats on winning your fight! Your current health is " + p1.getHeal() + ". Your current speed is " + p1.getSpeed() + ". Your current attack is " + p1.getAtt());
                }
                else{
                    winGame = false;
                    break;
                }
            }
            else if(encounter == 5){
                FastnHardZombie fastZomb = new FastnHardZombie();
                System.out.println("You encountered a " + fastZomb.zgetName());
                System.out.print("You're inventory currently contains: ");
                for(int i = 0; i<p1.getInv().size(); i++){
                    System.out.print(p1.getInv().get(i) + ", ");
                }
                System.out.println();
                System.out.println("Would you like to use an item before you fight? If so please enter your item here otherwise enter no. (If you don't enter no and enter something else we assume you want to use an item!): ");
                console.nextLine();
                String item = console.nextLine();
                if((!(item.equals("no")) & p1.getInv().size() != 0)){
                    boolean success = p1.useItem(item);
                    System.out.println(p1.getInv());
                while(success != true){
                    System.out.println("Please choose an item from your inventory:");
                    item = console.nextLine();
                    success = p1.useItem(item);
                }
                System.out.println("Here is your updated inventory: ");
                for(int i = 0; i<p1.getInv().size(); i++){
                    System.out.print(p1.getInv().get(i) + ", ");
                }
                System.out.println();
                }
                System.out.println("Now you will fight the zombie!");
                boolean winOrNot = p1.fight(fastZomb);
                if (winOrNot == true){
                    System.out.println("Congrats on winning your fight! Your current health is " + p1.getHeal() + ". Your current speed is " + p1.getSpeed() + ". Your current attack is " + p1.getAtt());
                }
                else{
                    winGame = false;
                    break;
                }
            }
            else if(encounter == 6 || encounter == 7|| encounter == 8 || encounter == 9){
                int randItem = rand.nextInt(10) + 1;
                if(randItem == 1 || randItem == 2){
                    System.out.println("You found a Lizal Boomerang!\n" + supInfo.description("Lizal Boomerang") +"\nHere is your updated inventory: " );
                    p1.addInv("Lizal Boomerang");
                    for(int i = 0; i<p1.getInv().size(); i++){
                        System.out.print(p1.getInv().get(i) + ", ");
                    }
                    System.out.println();
                    System.out.println("You will be able to use this item before your next battle safe travels onward!");
                }
                else if(randItem == 3){
                    System.out.println("You found a Master Sword!\n" + supInfo.description("Master Sword") +"\nHere is your updated inventory: " );
                    p1.addInv("Master Sword");
                    for(int i = 0; i<p1.getInv().size(); i++){
                        System.out.print(p1.getInv().get(i) + ", ");
                    }
                    System.out.println();
                    System.out.println("You will be able to use this item before your next battle safe travels onward!");
                }
                if(randItem == 4 || randItem == 5 || randItem == 6 || randItem == 7){
                    System.out.println("You found Cooked Meat!\n" + supInfo.description("Cooked Meat") +"\nHere is your updated inventory: " );
                    p1.addInv("Cooked Meat");
                    for(int i = 0; i<p1.getInv().size(); i++){
                        System.out.print(p1.getInv().get(i) + ", ");
                    }
                    System.out.println();
                    System.out.println("You will be able to use this item before your next battle safe travels onward!");
                }
                if(randItem == 8){
                    System.out.println("You found Hearty Simmered Fruit!\n" + supInfo.description("Hearty Simmered Fruit") +"\nHere is your updated inventory: " );
                    p1.addInv("Hearty Simmered Fruit");
                    for(int i = 0; i<p1.getInv().size(); i++){
                        System.out.print(p1.getInv().get(i) + ", ");
                    }
                    System.out.println();
                    System.out.println("You will be able to use this item before your next battle safe travels onward!");
                }
                if(randItem == 9  || randItem == 10){
                    System.out.println("You found Zora Boots!\n" + supInfo.description("Zora Boots") +"\nHere is your updated inventory: " );
                    p1.addInv("Zora Boots");
                    for(int i = 0; i<p1.getInv().size(); i++){
                        System.out.print(p1.getInv().get(i) + ", ");
                    }
                    System.out.println();
                    System.out.println("You will be able to use this item before your next battle safe travels onward!");
                }

            }
            else{
                System.out.println("You did not find anything this time contiue onwards with caution as you don't know what awaits you!");
            }
            mapDisplay(playMap, playerNewPos);
        }   
        console.close();
        if (winGame== false){
            System.out.println("Good Game "+ p1.getName() + "\nHope to see you playing again soon and hope you enjoyed the game!");
        }
        else{
            System.out.println("Congrats on winning the Game " + p1.getName() + "!\nHope to see you playing again soon and hope you enjoyed the game!");
        }
    }

    public static void mapDisplay(String[][] map, int[] coords){
        for(int i = 0; i<map.length;i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] =  "(" + i + "," + j + ")";
            }
        }
        map[0][5] = " exit";
        map[coords[0]][coords[1]] = "  X  ";
        for(int i = 0; i<map.length;i++){
            System.out.println();
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
        }
        System.out.println();
    }
    
}
