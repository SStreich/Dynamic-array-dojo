package com.codecool.dynamicArrayDojo;

public class Node<E> {
    private Node<E> nextNode;
    private E data;

    public Node(E data) {
        this.data = data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public boolean hasNext() {
        return nextNode != null;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public E getData() {
    return this.data;
    }

}
