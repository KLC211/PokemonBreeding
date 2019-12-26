package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Eggs {
    public static void destKnotProbs(float[] odds){
        float prob=-1;
        float random=1/32f;
        System.out.println("Odds of 6 IV: ");
        prob=random*odds[1]*odds[2]*odds[3]*odds[4]*odds[5]/6;
        prob+=random*odds[0]*odds[2]*odds[3]*odds[4]*odds[5]/6;
        prob+=random*odds[1]*odds[0]*odds[3]*odds[4]*odds[5]/6;
        prob+=random*odds[1]*odds[2]*odds[0]*odds[4]*odds[5]/6;
        prob+=random*odds[1]*odds[2]*odds[3]*odds[0]*odds[5]/6;
        prob+=random*odds[1]*odds[2]*odds[3]*odds[4]*odds[0]/6;
        System.out.println(prob*100+"%  with HA: "+prob*odds[6]*100+"% without HA: "+(prob*(1-odds[6])*100+"%"));

        System.out.println();
        System.out.println("Odds of 5 IV: ");

        prob=(1-random)*odds[1]*odds[2]*odds[3]*odds[4]*odds[5]*100/6;
        System.out.println("Atk/Def/SpA/SpD/Spd: "+ prob+"% ");
        System.out.println("with HA: "+prob*odds[6]+"% without HA: "+(prob*(1-odds[6])+"%"));

        prob=(1-random)*odds[0]*odds[2]*odds[3]*odds[4]*odds[5]*100/6;
        System.out.println("HP/Def/SpA/SpD/Spd: "+ prob+"% ");
        System.out.println("with HA: "+prob*odds[6]+"% without HA: "+(prob*(1-odds[6])+"%"));

        prob=(1-random)* odds[1]*odds[0]*odds[3]*odds[4]*odds[5]*100/6;
        System.out.println("HP/Atk/SpA/SpD/Spd: "+prob+"% ");
        System.out.println("with HA: "+prob*odds[6]+"% without HA: "+(prob*(1-odds[6])+"%"));

        prob=(1-random)*odds[1]*odds[2]*odds[0]*odds[4]*odds[5]*100/6;
        System.out.println("HP/Atk/Def/SpD/Spd: "+ prob+"% ");
        System.out.println("with HA: "+prob*odds[6]+"% without HA: "+(prob*(1-odds[6])+"%"));

        prob=(1-random)*odds[1]*odds[2]*odds[3]*odds[0]*odds[5]*100/6;
        System.out.println("HP/Atk/Def/SpA/Spd: "+(1-random)* prob+"% ");
        System.out.println("with HA: "+prob*odds[6]+"% without HA: "+(prob*(1-odds[6])+"%"));

        prob=(1-random)* odds[1]*odds[2]*odds[3]*odds[4]*odds[0]*100/6;
        System.out.println("HP/Atk/Def/SpA/SpD: "+prob+"% ");
        System.out.println("with HA: "+prob*odds[6]+"% without HA: "+(prob*(1-odds[6])+"%"));

        System.out.println();
        System.out.println("Odds of 4 IVs");

        LinkedList<LinkedList<String>> outp= new LinkedList<LinkedList<String>>();
        LinkedList<String> buffer = new LinkedList<>();
        boolean found=false;
        int count=0;
        for(int i=0; i<6; i++){
            for (int j=0; j<6; j++){
                for (int k=0; k<6; k++){
                    if(i!=k&&k!=j&&i!=j){
                        if (k==0)
                            buffer.add("HP");
                        if (k==1)
                            buffer.add("Atk");
                        if (k==2)
                            buffer.add("Def");
                        if (k==3)
                            buffer.add("SpA");
                        if (k==4)
                            buffer.add("SpD");
                        if (k==5)
                            buffer.add("Spd");

                        if(outp.isEmpty()){
                            outp.add(new LinkedList<String>());
                            outp.get(outp.size()-1).add(String.valueOf(buffer));
                        }

                        for (int e=0; e<outp.size(); e++){
                            if(outp.get(e).contains(buffer))
                                found=true;
                        }
                        if (found!=true) {
                            outp.get(outp.size() - 1).add(String.valueOf(buffer));
                        }
                        found=false;
                        buffer.clear();
                }
            }
        }
        }
        System.out.println(outp);
        for(int i=0; i<outp.size(); i++){
            for (int j=0; j<4; j++){
                System.out.print(outp.get(i).get(j));
                if (j==3)
                    System.out.print("/");
                else
                    System.out.println(":");
            }
        }
        outp.clear();

    }
    public static void noKnotProbs(float[] odds){
        return;
    }
}
