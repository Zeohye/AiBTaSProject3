import java.util.ArrayList;

/**
 * Created by Gamer PRO on 12/12/2014.
 */
public class ApproxHPFold {

    public static String fold(String seq){
        ArrayList<Integer> odds = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();

        seq = seq.toLowerCase();
        for(int i=0; i<seq.length();i++){
            if(i%2==0) {
                if (seq.charAt(i) == 'h')
                    evens.add(i);
            }
            else
                if(seq.charAt(i) == 'h')
                    odds.add(i);
        }

        int v1 = calcMatching(evens,odds,seq);
        int v2 = calcMatching(odds,evens,seq);

        String result;
        if(v1>v2)
            result = folding(evens,odds,seq);
        else
            result = folding(odds,evens,seq);

        return result;
    }

    private static String folding(ArrayList<Integer> l1, ArrayList<Integer> l2, String seq) {
        int startIndex = 0;
        int endIndex = seq.length()-1;
        String retL = "";
        String retR = "";

        for(int i=0; i<l1.size()&&i<l2.size();i++){
            int sNext = l1.get(i);
            int eNext = l2.get(l2.size()-i-1);
            if(sNext >= eNext){
                for(int k=endIndex-startIndex;k>0;){
                    if(seq.charAt(startIndex)==seq.charAt(endIndex) && k>1){
                        retL +="e";
                        retR = "w"+retR;
                        startIndex++;
                        endIndex--;
                        k=endIndex-startIndex;
                    }else {
                        //Change side
                        if(k==1)
                            retL +="n";
                        else
                            retL += "?";
                        k--;
                    }
                }

                break;
            }

            if(sNext-startIndex > 2) {
                //If next index doesn't match we need to make a detour. A detour will always be a even step size. 2,4,6 ect.
                retL += bend(sNext, startIndex, true);
                startIndex = sNext;
            }else{
                for(int k=sNext-startIndex;k>0;k--) {
                    retL += "e";
                    startIndex++;
                }
            }
            if(endIndex-eNext >2) {
                retR = bend(endIndex, eNext, false) + retR;
                endIndex = eNext;
            }else{
                for(int k=endIndex-eNext;k>0;k--) {
                    retR = "w" + retR;
                    endIndex--;
                }
            }
        }
        return retL+retR;
    }

    private static String bend(int index1,int index2,boolean front){
        String l = "";
        String r = "";
        int k = index1-index2;
        if(front){
            for(;k>2;k -=2){
                l +="n";
                r +="s";
            }
            l +="e";
            r +="e";
        }else{
            for(;k>2;k -=2){
                l +="s";
                r +="n";
            }
            l +="w";
            r +="w";
        }
        return l+r;
    }

    private static int calcMatching(ArrayList<Integer> l1,ArrayList<Integer> l2,String seq){
        int v=0;
        for(int i=0; i<l1.size()&&i<l2.size();i++){
            int startIndex = l1.get(i);
            int endIndex = l2.get(l2.size()-i-1);
            if(startIndex<endIndex)
                v++;
        }
        return v;
    }
}
