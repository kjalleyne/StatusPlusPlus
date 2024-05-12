/**
 * UserStats.java
 *
 * Represents the stats of a User.
 */
public class UserStats {
    private int intelligence;
    private int strength;
    private int endurance;
    private int wisdom;
    private int vitality;
    private int skillPoints;
    private int exp;

    /**
     * Constructor for UserStats class. Takes in all starting stats and assigns them.
     * @param intelligence  int
     * @param strength int
     * @param endurance int
     * @param wisdom int
     * @param vitality int
     * @param skillPoints int
     * @param exp int
     */
    public UserStats(int intelligence, int strength, int endurance, int wisdom, int vitality, int skillPoints, int exp) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.endurance = endurance;
        this.wisdom = wisdom;
        this.vitality = vitality;
        this.skillPoints = skillPoints;
        this.exp = exp;
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

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
