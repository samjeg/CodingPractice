import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

class Queries {
    public static void main(String[] param) {
        int[] arr = {3, 1, 2, 1};
        int[] arr2 = processQueries(arr, 5);

        for(int i=0; i<arr2.length; i++) {
            System.out.print(" "+arr2[i]);
        }
        System.exit(0);
    }

    public static int[] processQueries(int[] queries, int m) {
        int[] arr = new int[queries.length];
        List<Integer> ls = createP(m);

        // for each item in the list finds the item puts it at the start 
        // of  the list and record'd position that the item was found
        for(int i=0; i<queries.length; i++) {
            int next = queries[i];
            int j = 0;
            for(Iterator it = ls.iterator(); it.hasNext();) {
                Integer nextIt = (Integer) it.next();
                if(next == ls.get(j)) {
                    arr[i] = j;
                    ls.remove(nextIt);
                    ls.add(0, nextIt);
                    break;
                }
                j++;
            }
        }
        return arr;
    }

    public static int[] processQ(int[] queries, int m) {
        int[] arr = new int[queries.length];
        List<Integer> ls = createP(m);

        // for each item in the list finds the item puts it at the start 
        // of  the list and record'd position that the item was found
        for(int i=0; i<queries.length; i++) {
            int next = queries[i];
            
            for(int j=0; j<ls.size(); j++) {
                if(next == ls.get(j)) {
                    arr[i] = j;
                    try {
                        ls.remove(ls.get(j));
                        ls.add(0, ls.get(j));
                    } catch(ConcurrentModificationException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                j++;
            }
        }
        return arr;
    }

    // creates an arraylist with the numbers from 1 to m
    public static List<Integer> createP(int m) {
        List<Integer> ls = new ArrayList<Integer>();

        for(int i=1; i<=m; i++) {
            ls.add(i);
        }
        return ls;
    }
}