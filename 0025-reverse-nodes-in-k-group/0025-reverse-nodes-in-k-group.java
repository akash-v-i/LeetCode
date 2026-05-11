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
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr!=null) {
            ListNode next = curr;
            for (int i = 0; i < k - 1; i++) {
                if(next == null || next.next == null){
                    return dummy.next;
                }
                next = next.next;
            }
            ListNode tail=curr;
            ListNode nextgrp=next.next;
            next.next=null;
            ListNode newhead = reverse(curr);
            prev.next=newhead;
            tail.next=nextgrp;
            prev = tail;
            curr = nextgrp;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}