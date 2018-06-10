
/*
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

public class RotateList {

	public static ListNode rotateRight(ListNode node, int k) {
		if (node == null || k == 0) // validation
			return node;

		ListNode temp = node;

		// 1.calculate size
		int size = getSize(temp);
		
		// 2. take the modulus if length is greater than k
		if (k > size)
			k = k % size;

		// 3. base-cases extra validation
		if (k == 0 || size == 1 || k == size)
			return node;

		temp = node;
		for (int i = 0; i < size - k - 1; i++) { // note -1
			temp = temp.next;
		}
		ListNode newHead = temp.next; // head of rotated list
		temp.next = null; // cut into two parts
		temp = newHead;

		while (temp.next != null) { // go to end of the list
			temp = temp.next;
		}
		temp.next = node; // attach the first part
		return newHead;
	}
	
	private static int getSize(ListNode node) {
		ListNode temp = node;
		int size = 0;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int k = 2;
		ListNode rotatedList = rotateRight(head, k);
		while(rotatedList != null) {
			System.out.print(rotatedList.val + " ");
			rotatedList = rotatedList.next;
		}
	}
	private static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
