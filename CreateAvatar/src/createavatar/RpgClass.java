 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createavatar;


public class RpgClass implements Description {
    
    private final String className;
    private final int bHp;
    private final int bAtk;
    private final int bDef;
    private final int bSpd;
    private final int bMp;
    private String description;

    public RpgClass(String className, int bHp, int bAtk,
            int bDef, int bSpd, int bMp) {
        this.className = className;
        this.bHp = bHp;
        this.bAtk = bAtk;
        this.bDef = bDef;
        this.bSpd = bSpd;
        this.bMp = bMp;
    }
    
    //method implemented form interface description
    @Override
    public void writeDescrip(){
        System.out.print(" ");
    }
    
    //method to calculate stats of avatar based 
    //on level entered and base stats of class selected
    public void calcStats(Avatar avatar){
        int level = avatar.getLevel();
        avatar.setHp((int) (bHp*0.1*level));
        avatar.setAtk((int) (bAtk*0.1*level));
        avatar.setDef((int) (bDef*0.1*level));
        avatar.setSpd((int) (bSpd*0.1*level));
        avatar.setMp((int) (bMp*0.1*level));
        
    }

    public int getbHp() {
        return bHp;
    }

    public int getbAtk() {
        return bAtk;
    }

    public int getbDef() {
        return bDef;
    }

    public int getbSpd() {
        return bSpd;
    }

    public int getbMp() {
        return bMp;
    }

    public String getClassName() {
        return className;
    }

    public void setDescrip(String description) {
        this.description = description;
    }
    
    public String getDescrip(){
        return description;
    }

}
