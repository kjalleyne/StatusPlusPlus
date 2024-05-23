package com.example.statusplusplus.Classes;

/**
 * SkillPoints.java
 *
 * Represents the SkillPoints tied to another object. Could be used
 * for the User skillPoints, or tied to something like a "weapon"
 * or to award skillPoints from tasks if they are difficult ones.
 */
public class SkillLevels {

    /**
     * Levels of each skill area, as ints.
     */
    private int intelligence;
    private int strength;
    private int endurance;
    private int wisdom;
    private int vitality;


    /**
     * Contructor for skillPoints object.
     * @param intelligence int
     * @param strength int
     * @param endurance int
     * @param wisdom int
     * @param vitality int

     */
    public SkillLevels(int intelligence, int strength, int endurance, int wisdom, int vitality) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.endurance = endurance;
        this.wisdom = wisdom;
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
