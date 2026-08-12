/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        for(int i=0;i<k;i++){
            if(temp==null) return head;

            temp=temp.next;

        }
        ListNode groupStart=temp;
        ListNode newHead=reverse(head,groupStart);
        head.next=reverseKGroup(groupStart,k);
        return newHead;

        
    }
    public static ListNode reverse(ListNode head,ListNode stop){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=stop){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
