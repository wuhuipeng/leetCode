package cn.hereyou.stack;

/**
 * 最小栈 [155]
 *
 */
public class MinStack {
    private DoublyLinkedList list;
    private DoublyLinkedList minList;

    /** Initialize your data structure here. */
    public MinStack() {
        list = new DoublyLinkedList();
        minList = new DoublyLinkedList();
    }

    /** Push element val onto stack. */
    public void push(int val) {
        list.addFirst(val);
        if (minList.isEmpty() || val <= minList.getFirst()) {
            minList.addFirst(val);
        }
    }

    /** Removes the element on the top of the stack. */
    public void pop() {
        if (list.isEmpty()) {
            return;
        }
        int val = list.removeFirst();
        if (val == minList.getFirst()) {
            minList.removeFirst();
        }
    }

    /** Get the top element. */
    public int top() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    /** Retrieve the minimum element in the stack. */
    public int getMin() {
        if (minList.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minList.getFirst();
    }

    // Helper class for doubly linked list
    private class DoublyLinkedList {
        private Node head;
        private Node tail;

        private class Node {
            int value;
            Node prev;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }

        public DoublyLinkedList() {
            head = null;
            tail = null;
        }

        public void addFirst(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        public int removeFirst() {
            if (head == null) {
                throw new IllegalStateException("List is empty");
            }
            int value = head.value;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return value;
        }

        public int getFirst() {
            if (head == null) {
                throw new IllegalStateException("List is empty");
            }
            return head.value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0
        System.out.println(minStack.getMin()); // Returns -2
    }
}
