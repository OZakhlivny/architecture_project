package lesson5;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E>{
    private LinkedList.Node<E> current;
    private LinkedList.Node<E> previous;
    MyLinkedList<E> list;

    public LinkedListIterator(MyLinkedList<E> list){
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = list.firstElement;
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }

    public E getCurrent(){
        return current.item;
    }

    public void insertAfter(E value){
        if (list.isEmpty()){
            list.insertFirst(value);
            current = list.firstElement;
        } else {
            LinkedList.Node<E> newNode = new LinkedList.Node<>(value, null);
            newNode.next = current.next;
            current.next = newNode;
            nextLink();
            list.size++;
        }
    }

    public void insertBefore(E value){
        if(previous == null){
            list.insertFirst(value);
            reset();
        }
        else{
            LinkedList.Node<E> newNode = new LinkedList.Node<>(value, null);
            newNode.next = previous.next;
            previous.next = newNode;
            current = newNode;
            list.size++;
        }
    }

    public E deleteCurrent(){
        E data = current.item;

        if (previous == null){
            list.firstElement = current.next;
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) reset();
            else current = current.next;
        }
        list.size--;

        return data;
    }

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public E next() {
        E data = current.item;
        nextLink();
        return data;
    }
}
