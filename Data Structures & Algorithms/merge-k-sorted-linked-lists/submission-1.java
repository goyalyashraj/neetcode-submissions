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
    public ListNode mergeKLists(ListNode[] lists) {
        
 if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy ;
         for(int i =0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
             
                curr.next=temp ;
                curr=curr.next;
                temp = temp.next;
            }
           
         }
          curr.next = null;
         return sort(dummy.next);

    }
     private ListNode sort(ListNode node){
        if(node == null || node.next ==null)return node;
        ListNode mid = findmid(node);
        ListNode left = sort(node);
        ListNode right = sort(mid);
        return merge(left, right);

     }
     private ListNode findmid(ListNode node ){
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;
        while (fast != null && fast.next != null ){
            prev = slow;
            slow = slow.next;
            fast= fast.next.next;
        }
   if (prev != null) {
            prev.next = null; // break list into 2 parts
        }

        
        return slow;

     }
     private ListNode merge(ListNode node1,ListNode node2){
         ListNode dummy = new ListNode(0);
        ListNode curr = dummy ;
        while(node1!=null && node2!= null){
            if(node1.val<node2.val){
                curr.next = node1;
                node1= node1.next;
            }
            else{
                 curr.next = node2;
                node2= node2.next;
            }
           
            curr = curr.next;
        }
         if(node1!=null)                 
            { curr.next = node1;}
            else if(node2!=null){
                curr.next = node2;
            }
        return dummy.next;

     }

}
