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
    public ListNode removeNthFromEnd(ListNode head, int n) {

       ListNode temp=head;
       while(n-->0){
        temp=temp.next;
       }
       if(temp==null) return head.next;
       ListNode prev=head;
       while(temp!=null&& temp.next!=null){
         temp=temp.next;
         prev=prev.next;
       }
       ListNode del=prev.next;
       prev.next=del.next;
       del.next=null;
       return head;

    }
    
}
