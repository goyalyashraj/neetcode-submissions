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
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp!= null){
            ListNode kthNode = findKthNode(temp,k);

            if(kthNode == null){
                
                    if (prevNode != null) {
                    prevNode.next = temp;
                }

                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
           ListNode newHead  = reverse(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prevNode.next = newHead;
            }

                prevNode=temp;
                temp = nextNode;
            
        }
        return head;


        
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
                ListNode curr = head;

                while(curr != null){
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                return prev;

    }
    private ListNode  findKthNode(ListNode head, int k  ){
       k--;
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }
}
