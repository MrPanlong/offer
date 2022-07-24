package config;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 添加新的结点
    public ListNode add(int newval) {
        ListNode newNode = new ListNode(newval);
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(newval);
        }
        return this;
    }

    // 打印链表
    public void print() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print("-->");
            this.next.print();
        }else {
            System.out.println();
        }
    }
}
