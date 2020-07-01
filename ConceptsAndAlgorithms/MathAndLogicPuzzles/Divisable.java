
import java.util.*;

class Divisable {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */
    public static void main(String[] args) {
        int[] a = {19, 10, 12, 10, 24, 25, 22};
        List<Integer> ls = new ArrayList<Integer>();
        for(int i=0; i<a.length; i++) {
            ls.add(a[i]);
        }
        System.out.println("subset size: "+nonDivisibleSubset(4, ls));
        System.exit(0);
    }
    static List<Integer> subset = new ArrayList<Integer>();

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    // Write your code here
        int subPos = 1;

        for(int i=0; i<s.size() - 1; i++) {
            int next = s.get(i);

            for(int j=subPos; j<s.size(); j++) {
                int subNext = s.get(j);
                int sum = next + subNext;
                if(sum % k != 0) {
                    // System.out.println("i at s: "+s.get(i)+" - "+addable(s.get(i), k, subset)+" j at s: "+s.get(j)+" - "+addable(s.get(j), k, subset));
                    if(addable(s.get(i), k, subset)) subset.add(s.get(i));
                    if(addable(s.get(j), k, subset)) subset.add(s.get(j));
                }
            }
            subPos++;
        }
        return subset.size();
    }

    static boolean addable(int n, int k, List<Integer> s) {
        for(int i=0; i<s.size(); i++) {
           if((n + s.get(i)) % k == 0 || n == s.get(i)) return false;
        }
        return true; 
    }

    // static void addUniqueToSubset(int n) {
    //     int i = 0;
    //     boolean found = false;
    //     for(i=0; i<subset.size(); i++) {
    //         if(n == subset.get(i)) found = true;
    //     }
    //     if(subset.size() == 0 || !found) subset.add(n);
    // }

}



