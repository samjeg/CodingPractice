import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.lang.Math.*;

public class FreqQuery {

    public static void main(String[] args) throws IOException {
        
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> occMap = new HashMap<Integer, Integer>();
        List<Integer> ls = new ArrayList<Integer>();

        for(int i=0; i<queries.size(); i++) {
            int type = queries.get(i).get(0);
            int arg = queries.get(i).get(1);

            if(type == 1) {
                if(map.containsKey(arg)) {
                    int occ = map.get(arg);
                    int newOcc = occ + 1;

                    map.put(arg, newOcc);

                    occMap.put(occ, occMap.get(occ) - 1);

                    if(!occMap.containsKey(newOcc)) {
                        occMap.put(newOcc, 0);
                    }
                    occMap.put(newOcc, occMap.get(newOcc) + 1);
                } else {
                    map.put(arg, 1);
                    if(!occMap.containsKey(1)) {
                        occMap.put(1, 0);
                    }
                    occMap.put(1, occMap.get(1) + 1);
                }        
            } else if(type == 2) {
                if(map.containsKey(arg)) {
                    int occ = map.get(arg);
                    int newOcc = Math.max(occ - 1, 0);

                    map.put(arg, newOcc);

                    occMap.put(occ, occMap.get(occ) - 1);

                    if(!occMap.containsKey(newOcc)) {
                        occMap.put(newOcc, 0);
                    }
                    occMap.put(newOcc, occMap.get(newOcc) + 1);
                }
            } else {
                if(occMap.containsKey(arg) && occMap.get(arg) > 0) {
                    ls.add(1);
                } else {
                    ls.add(0);
                }
            }
        }
        return ls;
    }

    static List<Integer> fzFreqQuery(List<List<Integer>> queries) {
        List ans = new ArrayList<Integer>();
        final int INSERT = 1;
        final int REMOVE = 2;
        final int QUERY = 3;

        Map value2count = new HashMap<Integer, Integer>();
        Map count2countOccurance = new HashMap<Integer, Integer>();

        for (int i=0; i<queries.size(); i++) {
            int type = (int) queries.get(i).get(0);
            int value = (int) queries.get(i).get(1);

            if (type == INSERT) {
                if (value2count.containsKey(value)) {
                    int oldCount = (int) value2count.get(value);
                    int newCount = (int) oldCount + 1;

                    value2count.put(value, newCount);

                    count2countOccurance.put(oldCount, (int) count2countOccurance.get(oldCount) - 1);

                    if (!count2countOccurance.containsKey(newCount)) {
                        count2countOccurance.put(newCount, 0);
                    }
                    count2countOccurance.put(newCount, (int) count2countOccurance.get(newCount) + 1);
                } else {
                    value2count.put(value, 1);
                    if (!count2countOccurance.containsKey(1)) {
                        count2countOccurance.put(1, 0);
                    }
                    count2countOccurance.put(1, (int) count2countOccurance.get(1) + 1);
                }
            } else if (type == REMOVE) {
                if (value2count.containsKey(value)) {
                    int oldCount = (int) value2count.get(value);
                    int newCount = Math.max(oldCount - 1, 0);

                    value2count.put(value, newCount);

                    count2countOccurance.put(oldCount, (int) count2countOccurance.get(oldCount) - 1);

                    if (!count2countOccurance.containsKey(newCount)) {
                        count2countOccurance.put(newCount, 0);
                    }
                    count2countOccurance.put(newCount, (int) count2countOccurance.get(newCount) + 1);
                }
            } else if (type == QUERY) {
                if (count2countOccurance.containsKey(value) && (int) count2countOccurance.get(value) > 0) {
                    ans.add(1);
                } else {
                    ans.add(0);
                }
            }
        }

        return ans;
    }
}
