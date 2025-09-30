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

public class ReverseLinkedListII92 {
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
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode[] arr = traverseToNode(dummy, right, left);  // start from dummy
        ListNode prev = arr[0];  // node before sublist
        ListNode end = arr[1];   // right node
        ListNode start = prev.next;
        ListNode after = end.next;

        end.next = null; // break the sublist
        ListNode newSublistHead = reverseList(start);

        // reconnect
        prev.next = newSublistHead;
        start.next = after;

        return dummy.next;
    }

    public static ListNode[] traverseToNode(ListNode head, int right, int left) {
        ListNode[] result = new ListNode[2];
        ListNode current = head;

        for (int i = 0; i < right; i++) {
            if (i == left - 1) result[0] = current;    // node before left
            current = current.next;
            if (i == right - 1) result[1] = current;   // right node
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

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }
}
