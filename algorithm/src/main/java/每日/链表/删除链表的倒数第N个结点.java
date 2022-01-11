package 每日.链表;

/**
 * @author liutz
 * @date 2022/1/6
 */
public class 删除链表的倒数第N个结点 {


	static public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4,n5);
		ListNode n3 = new ListNode(3,n4);
		ListNode n2 = new ListNode(2,n3);
		ListNode n1 = new ListNode(1,n2);

		removeNthFromEnd(n1,5);

	}



	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (null == head) return null;
		int len = 1;
		ListNode p = head;
		while (null != p.next) {
			p = p.next;
			len++;
		}
		if (n == 0) return head;
		if (n > len) return null;
		if (n == len) {
			return head.next;
		}
		p = head;
		for (int i = 0; i < len - n - 1; i++) {
			p = p.next;
		}
		p.next = p.next.next;
		return head;
	}



}
