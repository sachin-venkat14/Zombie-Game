package Zombie_Project;
public class Supply {
    private String mastSword = "Master Sword";
    private String lizBoom = "Lizal Boomerang";
    private String heartyFood = "Hearty Simmered Fruit";
    private String meat = "Cooked Meat";
    private String zora = "Zora Boots";
    public String getMasSword(){
        return mastSword;
    }
    public String getliz(){
        return lizBoom;
    }
    public String getHearty(){
        return heartyFood;
    }
    public String getMeat(){
        return meat;
    }
    public String getZora(){
        return zora;
    }
    public String description(String name){
        if(name.toLowerCase().equals(mastSword.toLowerCase())){
            return "This is an attack item that will increase your attack stat by 15 permamently.";
        }
        else if (name.toLowerCase().equals(lizBoom.toLowerCase())){
            return "This is an attack item that will increase your attack stat by 8 permamently.";
        }
        else if (name.toLowerCase().equals(heartyFood.toLowerCase())){
            return "Use this item if your health is low. Using this item will increase your health by 40 points!";
        }
        else if(name.toLowerCase().equals(meat.toLowerCase())){
            return "Use this item if your health is low. Using this item will increase your health by 10 points.";
        }
        else if (name.toLowerCase().equals(zora.toLowerCase())){
            return "This item will increase your movement speed by 10!";
        }
        else{
            return "This is not an item!";
        }
        
    }
}
