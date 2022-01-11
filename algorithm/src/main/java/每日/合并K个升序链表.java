package 每日;

/**
 * @author liutz
 * @date 2022/1/7
 */
public class 合并K个升序链表 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1,new ListNode(2,new ListNode(5)));
		ListNode n2 = new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7))));
		ListNode n3 = new ListNode(2,new ListNode(6));

		ListNode node = mergeKLists(new ListNode[]{n1,n2});
		for (;;) {
			if (null == node)
				break;
			System.out.println(node.val);
			node = node.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		int i = 0;
		for (int j = 0; j < lists.length; j++) {
			if (null != lists[j]) {
				if (i == j) {
					i++;
					continue;
				} else {
					lists[i] = lists[j];
					lists[j] = null;
					i++;
				}
			}
		}
		if (0 == i) {
			return null;
		}
		i = 0;
		for (;;) {
			if (i*2+1 > lists.length || null == lists[i*2]) {
				i = 0;
				continue;
			}
			if (i*2+2 > lists.length || null == lists[i*2+1]) {
				if (i == 0) {
					return lists[0];
				}
				lists[i] = lists[i*2];
				lists[i*2] = null;
				i = 0;
				continue;
			}
			lists[i] = merge(lists[i*2],lists[i*2+1]);
			lists[i*2 + 1] = null;
			if (i != 0) {
				lists[i*2] = null;
			}
			i++;
		}
	}

	public static ListNode merge(ListNode l1,ListNode l2) {
		ListNode point = new ListNode();
		ListNode head = point;

		for (;;) {
			if (null == l1 && null == l2)
				break;

			if (null != l1 && (null == l2 || l1.val <= l2.val)) {
				point.next = l1;
				l1 = l1.next;
				point = point.next;
			}
			if (l2 != null && (null == l1 || l1.val > l2.val)) {
				point.next = l2;
				l2 = l2.next;
				point = point.next;
			}
		}
		return head.next;
	}

	public static class ListNode {
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
