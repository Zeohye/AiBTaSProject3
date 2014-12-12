/**
 * Created by Gamer PRO on 12/12/2014.
 */
public class Main {

    public static void main(String[] args) {
        String seq = "hhhhhhhhhhhhphphpphhpphhpphpphhpphhpphpphhpphhpphphphhhhhhhhhhhh";
        String seqFolding = "eeeeeeeeeeeeeeenesenesennesseeenwwsswnnwswnwswnwwwwwwwwwwwwwwww"; //<- true folding
        String result = ApproxHPFold.fold(seq);
        System.out.println("seq "+result.equals(seqFolding));

        seq = "hphhhhhh";
        result = ApproxHPFold.fold(seq);
        System.out.println(result);


    }

}
