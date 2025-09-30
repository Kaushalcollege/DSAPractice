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

public class ReorderList143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        display(head);
        System.out.println();
        reorderList(head);
        display(head);
        System.out.println();
    }
    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode headsecond = reverseList(mid);
        ListNode headfirst = head;

        while(headfirst != null && headsecond != null){
            ListNode temp = headfirst.next;
            headfirst.next = headsecond;
            headfirst = temp;

            temp = headsecond.next;
            headsecond.next = headfirst;
            headsecond = temp;
        }

        if (headfirst != null) headfirst.next = null;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // When fast reaches end, slow is in the middle   
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null){
            ListNode newNode = current.next;
            current.next = previous;
            previous = current;
            current = newNode;
        }
        return previous;
    }
}
