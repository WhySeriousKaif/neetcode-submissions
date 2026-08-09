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

        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        if(n>len) return head;
        if(n==len) return head.next;
        int trav_front=len-n;
        ListNode prev=null;
        temp=head;
        while(trav_front-->0){
            prev=temp;
            temp=temp.next;


        }
        prev.next=temp.next;
        temp.next=null;
        return head;

    }
    
}
