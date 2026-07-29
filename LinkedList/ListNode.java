/*
Problem:
206. Reverse LinkedList

Difficulty:
Easy

Topic:
LinkedList, HashMap

Approach:
1)Initialize a traversal pointer at the head of the linked list.
2)Also initialize a pointer for the previous node and set it to NULL.
3)Repeat the following steps until the traversal pointer reaches the end:
    Save the next node in a temporary pointer.
    Reverse the `next` pointer of the current node to point to the previous node.
    Move the previous pointer to the current node.
    Advance the traversal pointer to the next node (saved earlier).
4)Once the traversal is complete, return the previous node as the new head of the reversed list.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/reverse-linked-list/
*/


//  Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class solution{
     public ListNode reverseList(ListNode head) {
         // Initialize previous pointer to null
        ListNode prev = null;

        //start from the head of the List
        ListNode current = head;

        //travese the List
        while(current != null){

            //save the nextnode
            ListNode temp = current.next;

            // reverse the current node's pointer 
            current.next = prev;

            // Move prev to current node
            prev = current;

            //move to the next node
            current = temp;
        }

        // Return new head (last node becomes first)
        return prev;

    }
}