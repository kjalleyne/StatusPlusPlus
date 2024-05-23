package com.example.statusplusplus.Classes;

/**
 * UserStats.java
 *
 * Represents the stats of a User.
 */
public class UserStats {

    /**
     * The amount of exp the user has
     */
    private int exp;

    /**
     * The skill-levels of the user
     */
    private SkillLevels uSkillLevels;

    /**
     * The overall level of the user
     */
    private int level;

    /**
     * The currency that users will use to level up a skill-level
     */
    private int skillPoints;




    /**
     * Constructor for UserStats class. Takes in all starting stats and assigns them.

     * @param skillPoints int
     * @param exp int
     */
    public UserStats(int skillPoints, int exp, int level, SkillLevels skillLevels) {
        this.exp = exp;
        this.level = level;
        this.uSkillLevels = skillLevels;
        this.skillPoints = skillPoints;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public SkillLevels getuSkillLevels() {
        return uSkillLevels;
    }

    public void setuSkillLevels(SkillLevels uSkillLevels) {
        this.uSkillLevels = uSkillLevels;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }
}
