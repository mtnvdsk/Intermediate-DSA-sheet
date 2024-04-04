class pair {
    int start = 0;
    int end = 0;

    pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    // Function to find the maximum number of activities that can
    // be performed by a single person.
    public static int activitySelection(int start[], int end[], int n) {
        List<pair> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new pair(start[i], end[i]));
        }
        Collections.sort(arr, (x, y) -> {
            return x.end - y.end;
        });

        int count = 1; // At least one activity can be performed
        int prevend = arr.get(0).end; // End time of first activity
        for (int i = 1; i < n; i++) {
            if (arr.get(i).start > prevend) {
                count++;
                prevend = arr.get(i).end; // Update prevend
            }
        }
        return count;
    }
}