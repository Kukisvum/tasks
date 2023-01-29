package n2AddTwoNumbers;/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/


public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode10 = new ListNode(9);
        ListNode listNode3 = new ListNode(9, listNode10);
        ListNode listNode2 = new ListNode(9, listNode3);
        ListNode listNode1 = new ListNode(9, listNode2);
        ListNode listNode6 = new ListNode(8);
        ListNode listNode5 = new ListNode(8, listNode6);
        ListNode listNode4 = new ListNode(1);
        System.out.println(solution.addTwoNumbers(listNode4, listNode1));
    }
  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head = new ListNode();
         ListNode last = head;
        while (true) {
            ListNode currentNode1 = l1;
            ListNode currentNode2 = l2;
            ListNode newNode = null;
            if (currentNode1!=null && currentNode2!=null) {
                int sum = currentNode1.val + currentNode2.val;
                if (sum >= 10 && l1.next != null) {
                    newNode = new ListNode(sum % 10);
                    l1.next.val = l1.next.val + 1;
                } else if (sum >= 10 && l2.next != null) {
                    newNode = new ListNode(sum % 10);
                    l2.next.val = l2.next.val + 1;
                } else if (sum >= 10 && (l1.next == null || l2.next == null)) {
                    newNode = new ListNode(sum % 10, new ListNode(1));
                } else {
                    newNode = new ListNode(sum);
                }
                last.next = newNode;
                last = last.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (currentNode1!=null && currentNode2==null) {
                int sum = currentNode1.val;
                if (sum >= 10 && l1.next != null) {
                    newNode = new ListNode(sum % 10);
                    l1.next.val = l1.next.val + 1;
                }  else if (sum >= 10 && (l1.next == null)) {
                    newNode = new ListNode(sum % 10, new ListNode(1));
                } else {
                    newNode = new ListNode(sum);
                }
                last.next = newNode;
                last = last.next;
                l1 = l1.next;
            } else if (currentNode1==null && currentNode2!=null) {
                int sum = currentNode2.val;
                if (sum >= 10 && l2.next != null) {
                    newNode = new ListNode(sum % 10);
                    l2.next.val = l2.next.val + 1;
                }  else if (sum >= 10 && (l2.next == null)) {
                    newNode = new ListNode(sum % 10, new ListNode(1));
                } else {
                    newNode = new ListNode(sum);
                }
                last.next = newNode;
                last = last.next;
                l2 = l2.next;
            }

            if ((currentNode1 != null && currentNode2!= null)
                || (currentNode1 == null && currentNode2!= null)
                || (currentNode1 != null && currentNode2== null)) {
                continue;
            } else if (currentNode1==null && currentNode2== null ) {
                break;
            } else if(currentNode1.next == null && currentNode2.next == null) {
                break;
            }
        }
        last = head.next;
        return last;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "addTwoNumbers.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
