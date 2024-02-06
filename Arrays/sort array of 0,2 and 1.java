/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    where N is the length of the array/list.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int one = 0;
        int zero = 0;
        int two = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) {
                zero++;
            } else if (arr.get(i) == 1) {
                one++;
            } else {
                two++;
            }
        }

        int index = 0;

        while (zero-- > 0) {
            arr.set(index, 0);
            index++;
        }

        while (one-- > 0) {
            arr.set(index, 1);
            index++;
        }

        while (two-- > 0) {
            arr.set(index, 2);
            index++;
        }
    }

}
