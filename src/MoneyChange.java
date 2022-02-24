import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Change in a Foreign Currency
 * You likely know that different currencies have coins and bills of different denominations. In some currencies, it's actually impossible to receive change for a given amount of money. For example, Canada has given up the 1-cent penny. If you're owed 94 cents in Canada, a shopkeeper will graciously supply you with 95 cents instead since there exists a 5-cent coin.
 * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of money targetMoney. Both the denominations and target amount will be given in generic units of that currency.
 * Signature
 * boolean canGetExactChange(int targetMoney, int[] denominations)
 * Input
 * 1 ≤ |denominations| ≤ 100
 * 1 ≤ denominations[i] ≤ 10,000
 * 1 ≤ targetMoney ≤ 1,000,000
 * Output
 * Return true if it's possible to receive exactly targetMoney given the available denominations, and false if not.
 * Example 1
 * denominations = [5, 10, 25, 100, 200]
 * targetMoney = 94
 * output = false
 * Every denomination is a multiple of 5, so you can't receive exactly 94 units of money in this currency.
 * Example 2
 * denominations = [4, 17, 29]
 * targetMoney = 75
 * output = true
 * You can make 75 units with the denominations [17, 29, 29].
 *
 * */
public class MoneyChange {

    static HashMap<Integer, ArrayList> memoProcess = new HashMap<>();
    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        ArrayList<Integer> candidateNotes = new ArrayList<Integer>();
        ArrayList<Integer> children = new ArrayList<>();
        for(int eachNote: denominations){ // update the money note list
            if(targetMoney>=eachNote){
                candidateNotes.add(eachNote);
                children.add(targetMoney - eachNote);
            }
        }
        memoProcess.put(targetMoney,children);// insert the root record
        int result = bfs(targetMoney,children,candidateNotes);
        if(result == 0){return true;}
        return false;
    }

    static int bfs(int currentNode, ArrayList<Integer> children, ArrayList<Integer> notes){
        if(notes.contains(currentNode)){
            return 0;
        }
        int result = 1;
        for(int eachChild: children){
            if(memoProcess.containsKey(eachChild)){
                continue;
            }else{
                ArrayList<Integer> newValues = new ArrayList<>();
                for(int eachNote: notes){
                    if(eachChild-eachNote>=0){
                        newValues.add(eachChild-eachNote);
                    }
                }
                if(newValues.size()>0){
                    memoProcess.put(eachChild,newValues);
                    result = result*bfs(eachChild,newValues,notes);
                }
           }
        }
        return result;
    }


    public static void main(String[]args){
//        int targetMoney = 94;
//        int[] denominations = new int[]{5,10,25,100,200};
        int targetMoney = 75;
        int[] denominations = new int[]{4,17,29};
        boolean result = canGetExactChange(targetMoney,denominations);
        System.out.println(result);
        int index = 1;
        for(Integer eachKey:memoProcess.keySet()){
            index++;
            System.out.println(eachKey+"================"+memoProcess.get(eachKey).toString());
        }
        System.out.println(index);
    }
}
