import java.util.ArrayList;

/**
 * Created by Gamer PRO on 12/12/2014.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Problem 1:");
        String seq = "hphpphhphpphphhpphph";
        long sTime = System.currentTimeMillis();
        ArrayList<String> ret = ApproxHPFold.fold(seq);
        String result = ret.get(1);
        seq = ret.get(0);
        long eTime = System.currentTimeMillis();
        String time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime-sTime) +"ms");

        System.out.println();
        System.out.println("Problem 2:");
        seq = "hhhpphphphpphphphpph";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Problem 3:");
        seq = "ppphhpphhppppphhhhhhhpphhpppphhpphpp";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Problem 4:");
        seq = "hhphphphphhhhphppphppphpppphppphppphphhhhphphphphh";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Problem 5:");
        seq = "hhhhhhhhhhhhphphpphhpphhpphpphhpphhpphpphhpphhpphphphhhhhhhhhhhh";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Sequence 1:");
        seq = "pphpphhpppphhpppphhpppphh";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Sequence 2:");
        seq = "pphhhphhhhhhhhppphhhhhhhhhhphppphhhhhhhhhhhhpppphhhhhhphhphp";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Sequence 3:");
        seq = "hhhhpppphhhhhhhhhhhhpppppphhhhhhhhhhhhppphhhhhhhhhhhhppphhhhhhhhhhhhppphpphhpphhpphph";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Sequence 4:");
        seq = "pppppphphhppppphhhphhhhhphhpppphhpphhphhhhhphhhhhhhhhhphhphhhhhhhppppppppppphhhhhhhpphphhhpppppphphh";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");

        System.out.println();
        System.out.println("Sequence 5:");
        seq = "ppphhpphhhhpphhhphhphhphhhhpppppppphhhhhhpphhhhhhppppppppphphhphhhhhhhhhhhpphhhphhphpphphhhpppppphhh";
        sTime = System.currentTimeMillis();
        ret = ApproxHPFold.fold(seq);
        result = ret.get(1);
        seq = ret.get(0);
        eTime = System.currentTimeMillis();
        time = "Time to calculate fold: " + (eTime-sTime) +"ms";
        sTime = System.currentTimeMillis();
        ApproxHPFold.printFolding(seq,result);
        eTime = System.currentTimeMillis();
        System.out.println(time);
        System.out.println("Time to print fold, and calculate score: " + (eTime - sTime) + "ms");
    }

}
