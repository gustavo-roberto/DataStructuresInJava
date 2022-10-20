package data.structures;

import java.util.NoSuchElementException;

public class ListaLigadaImpl implements ListaLigada<Integer>{

    private Node first;
    private Node last;

    @Override
    public String toString() {
        return "ListaLigadaImpl{" + "\nInicio=" + first + '}';
    }

    @Override
    public void inserirInicio(Integer data) {
        Node node = new Node(data);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    @Override
    public void inserirFinal(Integer data) {
        Node node = new Node(data);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    @Override
    public Integer removerInicio() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            Node node = first;
            first = last = null;
            return node.value;
        }
        Integer valueFirst = first.value;

        Node second = first.next;
        first.next = null;
        first = second;
        return valueFirst;


    }

    @Override
    public Integer removerFinal() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            Integer node = first.value;
            first = last = null;
            return node;
        }
        Node node = first;
        while (isNotNull(node)) {
            if (node.next == last) {
                break;
            } else {
                node = node.next;
            }
        }
        Integer valueLast = node.next.value;
        node.next = null;
        last = node;
        return valueLast;
    }

    @Override
    public void imprimir() {
        System.out.println(this);

    }

    private boolean isEmpty() {
        return first == null;
    }

    private boolean isNotNull(Node node) {
        return node != null;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;

        }

        @Override
        public String toString() {
            return "Node{" + "\nvalue=" + value + ", \nnext=" + next + '}';
        }

    }
}
