package com.example.testapp;

import java.util.Random;

public class RandomTrain {
    public int len;
    private final Random random = new Random();
    private byte[] ar;
    private int randomFirstWagon;
    public RandomTrain() {
        reCreate();
    }
    public void reCreate(){
        len = random.nextInt(200) + 100; //от 100 до 300
        randomFirstWagon = random.nextInt(299);
        int ind = (int) Math.ceil((double) len/8.0);//окуруглит в большую сторону
        ar = new byte[ind];
        random.nextBytes(ar);
    }
    public boolean getNextWagon(){
        randomFirstWagon++;//c 0 до len-1
        if(randomFirstWagon >= len) randomFirstWagon = 0;
        int ind = (int) Math.floor((double) randomFirstWagon/8.0);//окуруглит в меньшую сторону
        int inBytePos = randomFirstWagon % 8;
        byte mask = (byte) ((byte) 1 << (byte)inBytePos);
        int b = ar[ind] & mask;
         if (b==0)  return false;
         else return true;
    }
}
