package com.example.demo;

public class IndPokemon {

    private boolean HP;
    private boolean Attack;
    private boolean Defense;
    private boolean SpecialAttack;
    private boolean SpecialDefense;
    private boolean Speed;
    private boolean HA;

    public void setAll(boolean[] stats, boolean hidden){
        HP=stats[0];
        Attack=stats[1];
        Defense=stats[2];
        SpecialAttack=stats[3];
        SpecialDefense=stats[4];
        Speed=stats[5];

        HA=hidden;
    }
}
