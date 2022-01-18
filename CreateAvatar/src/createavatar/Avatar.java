/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createavatar;

/**
 *
 * @author User
 */
public class Avatar {
    private String name;
    private int level;
    private String rpgClass;
    private int hp;
    private int atk;
    private int def;
    private int mp;
    private int spd;

    public Avatar(String name, int level, String occupation) {
        this.name = name;
        this.level = level;
        this.rpgClass = occupation;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setRpgClass(String rpgClass) {
        this.rpgClass = rpgClass;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public String getName() {
        return name;
    }

    public String getRpgClass() {
        return rpgClass;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getMp() {
        return mp;
    }

    public int getSpd() {
        return spd;
    }
    
}
