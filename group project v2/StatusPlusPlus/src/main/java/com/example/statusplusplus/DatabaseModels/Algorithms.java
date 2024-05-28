package com.example.statusplusplus.DatabaseModels;

public class Algorithms {
    /**
     * Multiply level by 100 and return.
     * @param level
     * @return The exp threshold needed to level up at a given level
     */
    public static int getExpThreshold(int level){
        return level * 100;
    }

    /**
     * Function to calculate the number of skill point to give a user based on level
     * y= 3 + 2 * FLOOR((x-1)/5))
     * Starting at 1 = 3, this function should go up by 2 skillpoints every 5 levels
     * @param level The level. Integer
     * @return Number of skillpoints the level should give. Type: Integer
     */
    public static int getSkillPointsGranted(int level){
        if(level < 1){
            throw new IllegalArgumentException("Level must be >= 1");
        }

        int increment = (int) Math.floor((double) (level - 1) /5);

        return 3 + 2 * increment;
    }
}
