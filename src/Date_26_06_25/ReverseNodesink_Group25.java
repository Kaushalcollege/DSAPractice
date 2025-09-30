package Date_26_06_25;

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseNodesink_Group25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2, right = 4;
        display(head);
        System.out.println();
        head = reverseBetween(head, left, right);
        display(head);
        int k = 2;
        head = reverseKGroup(head, k);
        display(head);
    }

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int rem = lengthOfList(head) % k;
        int total = lengthOfList(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tempHead = dummy.next;

        for (int i = 0; i < total - rem; i += k) {
            tempHead = reverseBetween(tempHead, i + 1, i + k);
        }

        return tempHead;
    }

    public static int lengthOfList(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode[] arr = traverseToNode(dummy, right, left);
        ListNode prev = arr[0];
        ListNode end = arr[1];
        ListNode start = prev.next;
        ListNode after = end.next;

        end.next = null;
        ListNode newSublistHead = reverseList(start);

        prev.next = newSublistHead;
        start.next = after;

        return dummy.next;
    }

    public static ListNode[] traverseToNode(ListNode head, int right, int left) {
        ListNode[] result = new ListNode[2];
        ListNode current = head;

        for (int i = 0; i < right; i++) {
            if (i == left - 1) result[0] = current;
            current = current.next;
            if (i == right - 1) result[1] = current;
        }
        return result;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
