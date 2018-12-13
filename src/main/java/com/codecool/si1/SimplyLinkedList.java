package com.codecool.dynamicArrayDojo;

import java.util.NoSuchElementException;

public class SimplyLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int length;

    public SimplyLinkedList() {
        this.length = 0;
    }

    public SimplyLinkedList(E data) {
        this.length = 1;
        Node<E> node = new Node<>(data);
        this.head = node;
        this.last = node;
    }

    public void add(E data) {
        Node<E> node = new Node<>(data);
        addNode(node);
    }

    public void addNode(Node<E> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            last.setNextNode(node);
        }
        this.last = node;
        this.length++;
    }

    public void insert(Node<E> node, E dataToInsert) {
        if (node.hasNext()) {
            Node nextNode = node.getNextNode();
            Node<E> nodeToInsert = new Node<>(dataToInsert);
            node.setNextNode(nodeToInsert);
            nodeToInsert.setNextNode(nextNode);
        } else {
            this.add(dataToInsert);
        }
    }

    public void remove(Node<E> nodeToRemove) {
        Node node = this.getHead();
        if (length > 0) {
            if (this.head.equals(nodeToRemove)) {
                Node temp = this.head.getNextNode();
                this.head = temp;
            } else {
                boolean isRemoved = false;
                while (!isRemoved) {
                    if (node.getNextNode().equals(nodeToRemove)) {
                        node.setNextNode(nodeToRemove.getNextNode());
                        isRemoved = true;
                    } else if (node.equals(last)) {
                        throw new NoSuchElementException("no such element!");
                    } else {
                        Node temp = node.getNextNode();
                        node = temp;
                    }
                }
            }
            this.length--;
        } else {
            throw new NoSuchElementException("no such element!");
        }
    }

    public Node<E> getHead() {
        return this.head;
    }

    public int getLength() {
        return this.length;
    }

    public SimplyLinkedList<E> getTail() {
        Node<E> node = this.getHead();
        SimplyLinkedList<E> linkedListCopy = new SimplyLinkedList<>();
        while (node.hasNext()) {
            linkedListCopy.add(node.getData());
            Node<E> temp = node.getNextNode();
            node = temp;
        }

        return linkedListCopy;
    }
}
