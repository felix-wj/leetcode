package cn.felix.q1_100;

public class Q2 {

 public static void main(String[] args) {
  int[] l1 = new int[]{9, 9, 9, 9, 9, 9, 9};
  int[] l2 = new int[]{9, 9, 9, 9};
  Q2 q2 = new Q2();
  ListNode listNode = q2.addTwoNumbers(q2.buildListNode(l1), q2.buildListNode(l2));
  listNode.print();
 }

 public ListNode buildListNode(int[] nums) {
  ListNode t = new ListNode(nums[0]);
  ListNode temp = t;
  for (int i = 1; i < nums.length; i++) {
   temp.next = new ListNode(nums[i]);
   temp = temp.next;
  }
  return t;
 }

 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  ListNode t1 = l1.next;
  ListNode t2 = l2.next;
  int i = l1.val + l2.val;
  ListNode t = new ListNode(i % 10);
  ListNode temp = t;
  int add = i / 10;
  while (t1 != null || t2 != null) {
   i = add;
   if (t1 != null) {
    i += t1.val;
    t1 = t1.next;
   }
   if (t2 != null) {
    i += t2.val;
    t2 = t2.next;
   }
   temp.next = new ListNode(i % 10);
   add = i / 10;
   temp = temp.next;
  }
  if (add > 0) {
   temp.next = new ListNode(add);
  }
  return t;
 }

 public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
   this.val = val;
  }

  ListNode(int val, ListNode next) {
   this.val = val;
   this.next = next;
  }

  public void print() {
   System.out.print(val);
   System.out.print(" ");
   ListNode temp = next;
   while (temp != null) {
    System.out.print(temp.val);
    System.out.print(" ");
    temp = temp.next;
   }
  }
 }
}
