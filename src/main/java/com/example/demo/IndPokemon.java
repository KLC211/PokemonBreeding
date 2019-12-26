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

    public boolean isHP() {
        return HP;
    }
    public boolean isAttack() {
        return Attack;
    }
    public boolean isDefense() {
        return Defense;
    }
    public boolean isSpecialAttack() {
        return SpecialAttack;
    }
    public boolean isSpecialDefense() {
        return SpecialDefense;
    }
    public boolean isSpeed() {
        return Speed;
    }
    public boolean isHA() {
        return HA;
    }

    public void setHP(boolean HP) {
        this.HP = HP;
    }
    public void setAttack(boolean attack) {
        Attack = attack;
    }

    public void setDefense(boolean defense) {
        Defense = defense;
    }

    public void setSpecialAttack(boolean specialAttack) {
        SpecialAttack = specialAttack;
    }

    public void setSpecialDefense(boolean specialDefense) {
        SpecialDefense = specialDefense;
    }

    public void setSpeed(boolean speed) {
        Speed = speed;
    }

    public void setHA(boolean HA) {
        this.HA = HA;
    }
}
