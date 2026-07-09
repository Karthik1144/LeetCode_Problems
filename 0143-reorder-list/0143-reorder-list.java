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
        if (head == null || head.next == null)
            return;
        ListNode slow = head,fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid =  reverse(slow.next);
        slow.next = null;
        ListNode first = head;
        while(mid!=null){
            ListNode t1 = first.next;
            ListNode t2 = mid.next;

            first.next = mid;
            mid.next = t1;

            first = t1;
            mid = t2;
        }
        return ;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = head, curr =head.next;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev= curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;
        return head;
    }
}