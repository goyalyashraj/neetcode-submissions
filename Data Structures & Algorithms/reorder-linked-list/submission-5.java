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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null )return;

        ListNode slow = head;
         ListNode fast = head;
         ListNode prev = null;


        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast= fast.next.next;
          
        }
        ListNode curr= slow.next;
        slow.next =null;
        while (curr!=null){
             ListNode next = curr.next;
             curr.next =prev;
             prev = curr;
             curr = next;
        }
        ListNode temp1 = prev;
         ListNode temp2 = head;
         while(temp1 != null){
            ListNode temp11 = temp1.next;
            ListNode temp22= temp2.next;

           temp2.next = temp1;
           temp1.next = temp22;

           temp1 =temp11;
           temp2= temp22;
            
         }
         
        
    }
}
