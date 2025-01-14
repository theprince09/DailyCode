/*
 *You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
  
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        
        List<Integer> ls = new ArrayList<>();
        for(ListNode node:lists){
            while(node != null){
                ls.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(ls);

        ListNode link = new ListNode(-1);
        ListNode curr = link;

        for(int value:ls){
            curr.next = new ListNode(value);
            curr = curr.next;
        }
        return link.next;
    }
}

public class MergeLinkList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of linked lists:");
        int k = scanner.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            System.out.println("Enter the size of linked list " + (i + 1) + ":");
            int size = scanner.nextInt();
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            System.out.println("Enter elements of linked list " + (i + 1) + ":");
            for (int j = 0; j < size; j++) {
                int val = scanner.nextInt();
                current.next = new ListNode(val);
                current = current.next;
            }
            lists[i] = dummy.next;
        }

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeKLists(lists);

        System.out.println("Merged Sorted Linked List:");
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
    }
}
