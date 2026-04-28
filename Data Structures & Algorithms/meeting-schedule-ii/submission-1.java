/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0) return 0;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer>p=new PriorityQueue<>();

        int maxRooms=0;
        for(Interval meeting:intervals){
            if(!p.isEmpty() && p.peek()<=meeting.start ){
                p.poll();
            }

            p.offer(meeting.end);

            maxRooms=Math.max(maxRooms,p.size());

        }
        return maxRooms;

    }
}
