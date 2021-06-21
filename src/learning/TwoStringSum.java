package learning;

public class TwoStringSum {

	public static void main(String[] args) {
		TwoStringSum twoStringSum = new TwoStringSum();
		ListNode l16 = new ListNode(9);
		ListNode l15 = new ListNode(9, l16);
		ListNode l14 = new ListNode(9, l15);
		ListNode l13 = new ListNode(9, l14);
		ListNode l12 = new ListNode(9, l13);
		ListNode l11 = new ListNode(9, l12);
		ListNode l1 = new ListNode(9, l11);

		//ListNode l1 = new ListNode(0);

		/*ListNode l12 = new ListNode(3);
		ListNode l11 = new ListNode(4, l12);
		ListNode l1 = new ListNode(2, l11);*/

		ListNode l23 = new ListNode(9);
		ListNode l22 = new ListNode(9, l23);
		ListNode l21 = new ListNode(9, l22);
		ListNode l2 = new ListNode(9, l21);

		//ListNode l2 = new ListNode(0);

		/*ListNode l22 = new ListNode(4);
		ListNode l21 = new ListNode(6, l22);
		ListNode l2 = new ListNode(5, l21);*/

		ListNode node = twoStringSum.addTwoNumbers(l1, l2);

		while (node != null) {
			System.out.print(node.val);
			node = node.next;
		}
	}

	/*
	 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	 * Output: [8,9,9,9,0,0,0,1]
	 * */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean carry = false;
		int temp = l1.val + l2.val;
		ListNode node = new ListNode(temp % 10);
		ListNode currentNode = node;
		if (temp >= 10) {
			carry = true;
		}
		while (l1.next != null || l2.next != null) {
			if (l1.next != null && l2.next != null) {
				l1 = l1.next;
				l2 = l2.next;
				temp = l1.val + l2.val;
			} else if (l1.next != null) {
				l1 = l1.next;
				temp = l1.val;
			} else {
				l2 = l2.next;
				temp = l2.val;
			}
			if (carry) {
				temp++;
				carry = false;
			}
			if (temp >= 10) {
				carry = true;
			}
			currentNode.next = new ListNode(temp % 10);
			currentNode = currentNode.next;
		}
		if (carry) {
			currentNode.next = new ListNode(1);
		}
		return node;
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	static class ListNode {
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
	}
}
