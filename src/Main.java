/**
 * Created by Gamer PRO on 12/12/2014.
 */
public class Main {

    public static void main(String[] args) {
        String seq = "hhhhhhhhhhhhphphpphhpphhpphpphhpphhpphpphhpphhpphphphhhhhhhhhhhh";
        String result = ApproxHPFold.fold(seq);
/*
        seq = "hphhhhhh";
        result = ApproxHPFold.fold(seq);
        System.out.println(result);*/

        ApproxHPFold.printFolding(seq,result);
    }

}
