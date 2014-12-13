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
                            retL +="s";
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

    public static void printFolding(String seq,String fold){
        ArrayList<char[]> foldingChars = new ArrayList<char[]>();
        ArrayList<char[]> foldingSymbols = new ArrayList<char[]>();
        ArrayList<char[]> foldingSymbolsUp = new ArrayList<char[]>();
        ArrayList<char[]> foldingHyBack = new ArrayList<char[]>();

        char[] folda = fold.toCharArray();
        char[] workingChars = new char[seq.length()];
        char[] workingBars = new char[seq.length()];
        char[] workingBarsUp = new char[seq.length()];
        char[] workingHyBack = new char[seq.length()];

        foldingChars.add(workingChars);
        foldingSymbols.add(workingBars);
        foldingSymbolsUp.add(workingBarsUp);
        foldingHyBack.add(workingHyBack);

        int indexX = 0;
        int indexY = 0;
        for(int i=0; i<seq.length()-1;i++){
            switch(folda[i]){
                case 'e':
                    workingBars[indexX]='-';
                    workingChars[indexX]=seq.charAt(i);
                    indexX++;
                    break;
                case 'n':
                    workingChars[indexX]=seq.charAt(i);
                    indexY--;
                    if(indexY >=0 && foldingChars.get(indexY)!=null){
                        workingBars = foldingSymbols.get(indexY);
                        workingChars = foldingChars.get(indexY);
                        workingBarsUp = foldingSymbolsUp.get(indexY);
                        workingHyBack = foldingHyBack.get(indexY);
                    }else{
                        if(indexY<0)
                            indexY=0;
                        workingBars = new char[seq.length()];
                        workingChars = new char[seq.length()];
                        workingBarsUp = new char[seq.length()];
                        workingHyBack = new char[seq.length()];
                        foldingChars.add(indexY,workingChars);
                        foldingSymbols.add(indexY,workingBars);
                        foldingSymbolsUp.add(indexY,workingBarsUp);
                        foldingHyBack.add(workingHyBack);
                    }
                    workingBarsUp[indexX]='|';
                    break;
                case 's':
                    workingBars[indexX]='|';
                    workingChars[indexX]=seq.charAt(i);
                    indexY++;
                    if(foldingChars.size()>indexY){
                        workingBars = foldingSymbols.get(indexY);
                        workingChars = foldingChars.get(indexY);
                        workingBarsUp = foldingSymbolsUp.get(indexY);
                        workingHyBack = foldingHyBack.get(indexY);
                    }else{
                        workingBars = new char[seq.length()];
                        workingChars = new char[seq.length()];
                        workingBarsUp = new char[seq.length()];
                        workingHyBack = new char[seq.length()];
                        foldingChars.add(indexY,workingChars);
                        foldingSymbols.add(indexY,workingBars);
                        foldingSymbolsUp.add(indexY,workingBarsUp);
                        foldingHyBack.add(workingHyBack);
                    }
                    break;
                case 'w':
                    workingHyBack[indexX]='-';
                    workingChars[indexX]=seq.charAt(i);
                    indexX--;
                    break;
            }
        }
        workingChars[indexX]=seq.charAt(seq.length()-1);
        for(int j=0; j<foldingChars.size();j++){
            char[] ca = foldingChars.get(j);
            char[] sa = foldingSymbols.get(j);
            char[] saBarUp = foldingSymbolsUp.get(j);
            char[] saHyUp = foldingHyBack.get(j);
            String c = "";
            String s = "";
            for(int i=0; i<ca.length;i++){
                if(sa[i]=='-') {
                    c +=ca[i] + "\t" + "-" + "\t";
                    if(saBarUp[i]=='|')
                        s += "|" +"\t" + " " + "\t";
                    else
                        s += " " +"\t" + " " + "\t";
                } else if((sa[i]=='|')) {
                        c += ca[i] + "\t" + " " + "\t";
                        s += "|" + "\t" + " " + "\t";
                }else{
                    if(saHyUp[i]=='-')
                        c = c.substring(0,c.length()-2) + "-" + "\t" + ca[i] + "\t" + " " + "\t";
                    else
                        c += ca[i] + "\t" + " " + "\t";
                    if(saBarUp[i]=='|')
                        s += "|" +"\t" + " " + "\t";
                    else
                        s += " " +"\t" + " " + "\t";
                }
            }
            System.out.println(c);
            System.out.println(s);
        }
    }
}
