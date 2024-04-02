class Solution {
    public static int maxMeetings(int start[], int end[], int n) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }
        Collections.sort(meetings, Comparator.comparingInt(a -> a.end));

        int prevEnd = 0;
        int maxMeetingsCount = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start > prevEnd) {
                maxMeetingsCount++;
                prevEnd = meeting.end;
            }
        }

        return maxMeetingsCount;
    }
    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}