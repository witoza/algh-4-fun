package org.wito;

class MySinlgleLinkedList<T> {

    static class Node<T> {
        Node<T> next;
        T value;

        @Override
        public String toString() {
            if (next == null) {
                return "" + value;
            }
            return value + "\t [next=" + next.value + "]";
        }
    }

    Node<T> head;

    void add(T t) {

        Node<T> node = new Node<T>();
        node.value = t;

        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = tail(head);
        tail.next = node;
    }

    void print() {
        if (head == null) {
            return;
        }
        Node<T> curr = head;
        do {
            System.out.println(curr);
            curr = curr.next;
        } while (curr != null);
        System.out.println("-------");
    }

    static <T> Node<T> tail(Node<T> node) {
        if (node.next != null) {
            return tail(node.next);
        } else {
            return node;
        }
    }

    void reverse1() {
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            Node<T> tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;

        }
        head = prev;
    }

    void reverse2() {
        Node<T> nw = null;
        while (head != null) {
            Node<T> tmp = head;
            head = head.next;
            tmp.next = nw;
            nw = tmp;
        }
        head = nw;
    }

    Node<T> reverse3_impl(Node<T> curr) {
        Node<T> next = curr.next;
        if (next == null) {
            return curr;
        }
        Node<T> rest = reverse3_impl(next);
        curr.next = null;
        next.next = curr;
        return rest;
    }

    void reverse3() {
        if (head == null) {
            return;
        }
        head = reverse3_impl(head);

    }
}

public class ListReverse {

    public static void main(String[] args) {

        MySinlgleLinkedList<Integer> ml = new MySinlgleLinkedList<Integer>();
        ml.add(1);
        ml.add(21);
        ml.add(311);
        ml.add(4111);
        ml.add(51111);

        ml.print();
        ml.reverse3();
        ml.print();
        ml.reverse3();
        ml.print();

    }
}
