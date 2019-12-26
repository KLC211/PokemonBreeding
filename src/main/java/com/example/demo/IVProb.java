package com.example.demo;

import java.util.ArrayList;

public class IVProb {
    public static float[] IVPerm(IndPokemon mother, IndPokemon father){
        float prob[]=new float[7];
        for (int i=0; i<7;i++)
            prob[i]=1;

        if (mother.isHP() == true && father.isHP() == true)
            prob[0] = prob[0] * 1;
        else if (mother.isHP() == false ^ father.isHP() == false) {
            prob[0] = (float) (prob[0] * 0.5);
        } else {
            prob[0] = prob[0] * 1/32;
        }

        if (mother.isAttack()==true&&father.isAttack()==true)
            prob[1]=prob[1]*1;
        else if (mother.isAttack()==false ^ father.isAttack()==false){
            prob[1]= (float) (prob[1]* 0.5);
        }
        else {
            prob[1]=prob[1]*1/32;
        }

        if (mother.isDefense() == true && father.isDefense() == true)
            prob[2] = prob[2] * 1;
        else if (mother.isDefense() == false ^ father.isDefense() == false) {
            prob[2] = (float) (prob[2] * 0.5);
        } else {
            prob[2] = prob[2] * 1/32;
        }

        if (mother.isSpecialAttack() == true && father.isSpecialAttack() == true)
            prob[3] = prob[3] * 1;
        else if (mother.isSpecialAttack() == false ^ father.isSpecialAttack() == false) {
            prob[3] = (float) (prob[3] * 0.5);
        } else {
            prob[3] = prob[3] * 1/32;
        }

        if (mother.isSpecialDefense() == true && father.isSpecialDefense() == true)
            prob[4] = prob[4] * 1;
        else if (mother.isSpecialDefense() == false ^ father.isSpecialDefense() == false) {
            prob[4] = (float) (prob[4] * 0.5);
        } else {
            prob[4] = prob[4] * 1/32;
        }

        if (mother.isSpeed() == true && father.isSpeed() == true)
            prob[5] = prob[5] * 1;
        else if (mother.isHP() == false ^ father.isHP() == false) {
            prob[5] = (float) (prob[5] * 0.5);
        } else {
            prob[5] = prob[5] * 1/32;
        }

        if (mother.isHA()){
            prob[6]= (float) 0.6;
        }
        else
            prob[6]=0;

        return prob;

    }

}

