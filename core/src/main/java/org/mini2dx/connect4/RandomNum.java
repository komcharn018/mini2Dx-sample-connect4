package org.mini2dx.connect4;

import java.util.Random;

public class RandomNum
{
    private static int upperBound = 4;
    Random rand = new Random();
    protected int numRand = rand.nextInt(upperBound);

    public int getRandNum()
    {
        return this.numRand;
    }

}